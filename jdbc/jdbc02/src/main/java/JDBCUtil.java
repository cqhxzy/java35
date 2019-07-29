import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class JDBCUtil{
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

    /**
     * 通用的DML操作的方法
     * @param sql
     * @param params
     * @return
     */
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

    /**
     * 通用的查询全部的功能,这个通用的查询只能够查单标
     * @param tClass 泛型对应类
     * @param sql 要执行的查询语句
     * @param params 查询的参数
     * @param <T> 泛型
     * @return 查询得到的结果
     */
    public <T> List<T> queryAll(Class<T> tClass,String sql,Object...params){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<>();

        try {
            connection = this.getConnection();
            preparedStatement = connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    //为SQL语句中的参数赋值
                    preparedStatement.setObject(i + 1,params[i]);
                }
            }

            //执行sql语句
            rs = preparedStatement.executeQuery();

            //通过ResultSet对象，获取查询的SQL语句的元数据，元数据中包括了查询的SQL语句的列的个数，以及列名
            ResultSetMetaData metaData = rs.getMetaData();

            while (rs.next()){
                int columnCount = metaData.getColumnCount();//返回查询语句中，查询的列的个数
                T obj = tClass.newInstance(); //通过反射，调用无参构造方法实例化空的对象

                //通过循环为obj中的属性赋值
                for (int i = 1; i <= columnCount ; i++) {
                    String columnLabel = metaData.getColumnLabel(i);//获取查询的SQL语句的列名
                    Object value = rs.getObject(i);

                    //System.out.println("columnLabel:" + columnLabel + ",value:" + value);
                    //columnLabel列名必须和T所对应的类中的属性名一致。
                    BeanUtils.setProperty(obj,columnLabel,value); //为obj这个对象的columnLabel属性赋值为value
                }

                list.add(obj);
                logger.debug("build obj:" + obj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } finally {
            this.closeAll(connection,preparedStatement,rs);
        }
        return list;
    }

}
