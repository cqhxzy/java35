import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    private static String DRIVER;
    private static String URL;
    private static String USER;
    private static String PASSWORD;
    private static Logger logger = LoggerFactory.getLogger(JDBCUtil.class);
    static{
        //读取配置文件，得到连接字符串
        InputStream resourceAsStream = JDBCUtil.class.getResourceAsStream("/jdbc.properties");
        Properties prop = new Properties();
        try {
            prop.load(resourceAsStream);
            //从配置文件中读取数据
            DRIVER = prop.getProperty("driver");
            URL = prop.getProperty("url");
            USER = prop.getProperty("user");
            PASSWORD = prop.getProperty("password");

            logger.debug(DRIVER);
            logger.debug(URL);
            logger.debug(USER);
            logger.debug(PASSWORD);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Class.forName(DRIVER); //加载驱动类
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * @return
     */
    public Connection getConnection(){
        try {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭连接，释放资源
     * @param connection
     * @param preparedStatement
     * @param resultSet
     */
    public void closeAll(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet){
        try {
            if (resultSet != null)
                resultSet.close();

            if (preparedStatement != null)
                preparedStatement.close();

            if (connection != null)
                connection.close();
            logger.debug("execute close method");
        } catch (SQLException e){
            logger.error(e.getMessage());
        }
    }

    public int executeUpdate(String sql,Object...params){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = this.getConnection();
            preparedStatement = connection.prepareStatement(sql);

            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    preparedStatement.setObject(i + 1,params[i]); //为SQL语句中的参数赋值
                }
            }

            //执行SQL语句
            int executeUpdate = preparedStatement.executeUpdate();
            logger.debug("execute DML,and effective row is " + executeUpdate);
            return executeUpdate;

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(connection,preparedStatement,null);
        }
        return 0; //return 0 说明数据库操作失败
    }
}
