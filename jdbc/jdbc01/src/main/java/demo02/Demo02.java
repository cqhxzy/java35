package demo02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Arrays;

public class Demo02 {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://192.168.91.188:3306/wulin?useUnicode=true&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private Logger logger = LoggerFactory.getLogger(Demo02.class);
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库的连接
     * @return
     */
    public Connection getConnection(){
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    /**
     * 关闭连接
     * @param connection
     * @param pstmt
     * @param rs
     */
    public void closeAll(Connection connection, PreparedStatement pstmt, ResultSet rs){
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (connection != null) connection.close();
        } catch (SQLException e){
            logger.error(e.getMessage());
        }
    }


    public int executeUpdate(String sql,Object...params){
        //打开连接
        Connection connection = getConnection();

        //PreparedStatement接口是一种预处理SQL语句的对象
        //在使用Statement接口时，如果sql语句中有参数，是直接将参数写到sql语句中
        //通过PreparedStatement实现预处理sql语句时，所有参数都用占位符表示。占位符通过?表示
        //在预处理sql语句时，再将占位符对应的参数，传递到预处理

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);//预处理sql语句
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1,params[i]);
                }
            }
            int row = preparedStatement.executeUpdate();//执行DML操作的方法，返回数据库受影响的行数
            logger.debug(sql + ":" + Arrays.toString(params) + ",row:" + row);
            return row;
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            closeAll(connection,preparedStatement,null); //关闭连接
        }
        return -1;
    }
}
