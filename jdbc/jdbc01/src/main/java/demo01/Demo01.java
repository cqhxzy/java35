package demo01;
import com.mysql.cj.protocol.Resultset;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo01 {
    private Logger logger = LoggerFactory.getLogger(Demo01.class);

    /**
     * 建立与数据库的连接
     * @return
     */
    public Connection getConnection(){
        /*
         * 学习反射时，讲过了类加载器
         * Student stu = new Student();
         *
         * 要和数据库连接，必须要知道数据库的驱动类
         * 1.加载驱动类
         * */
        try {
            /*Class<?> driver_class = Class.forName("com.mysql.cj.jdbc.Driver");//加载驱动类
            Driver driver = (Driver) driver_class.newInstance();
            //注册驱动
            DriverManager.registerDriver(driver);*/

            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://192.168.91.188:3306/wulin?useUnicode=true&characterEncoding=utf8";

            //建立和数据库的连接
            Connection connection = DriverManager.getConnection(url, "root", "root");
            logger.debug("建立和数据库的连接",connection);
            return connection;
        } catch (ClassNotFoundException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
        logger.debug("getConnection() was invocked,but return null value");
        return null;
    }

    /**
     * 执行DML操作的方法
     * @param sql
     * @return
     */
    public int executeUpdate(String sql){
        Connection connection = getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            int row = statement.executeUpdate(sql);
            return row; //返回数据库受影响的函数
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection,statement,null);
        }
        return -1;
    }

    public List<Map<String,Object>> query(String sql){
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet rs = null;
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(sql); //执行了sql语句后，数据库返回的结果集在ResultSet对象中
            while (rs.next()){ //判断rs对象中是否还有下一条数据可遍历
                int id = rs.getInt(1); //获取第一列的值。
                String name = rs.getString("name"); //根据列名获取值

                //一个map集合，就代表了一行数据
                Map<String, Object> row = new HashMap<String, Object>();
                row.put("id",id);
                row.put("name",name);

                list.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeAll(connection,statement,rs);
        }
        return list;
    }


    /**
     * 关闭连接，释放资源
     * @param conn
     * @param statement
     * @param rs
     */
    public void closeAll(Connection conn, Statement statement, ResultSet rs){
        try {
            if (rs != null) rs.close();
            if (statement != null) statement.close();
            if (conn != null) conn.close();
        } catch (SQLException e){
            logger.error(e.getMessage());
        }
    }

    public void doSth(){
        Connection connection = getConnection();
        try {
            Statement statement = connection.createStatement();

            //System.out.println(statement);
            String sql = "insert into tab_my_test values (6,'test1')";

            int row = statement.executeUpdate(sql); //执行DML操作的SQL语句，返回数据库受影响的行数
            System.out.println(row > 0 ? "添加成功":"添加失败");

            closeAll(connection,statement,null);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        demo01.doSth();
    }
}
