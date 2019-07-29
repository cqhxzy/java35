import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IDepartmentImpl implements IDepartMent {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://192.168.91.188:3306/wulin?useUnicode=true&characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private Logger logger = LoggerFactory.getLogger(IDepartmentImpl.class);

    static{
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    @Override
    public int save(Department department) {
        String sql = "insert into department (deptId,deptName,deptAddress) values(?,?,?)";

        //获取数据库连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            //通过Connection得到预处理SQL语句的对象
            preparedStatement = connection.prepareStatement(sql);

            //因为SQL语句有参数，为SQL语句的参数赋值
            preparedStatement.setInt(1,department.getDeptId());
            preparedStatement.setString(2,department.getDeptName());
            preparedStatement.setString(3,department.getDeptAddress());

            //执行DML操作
            int executeUpdate = preparedStatement.executeUpdate();
            logger.debug("执行结果：" + executeUpdate);
            return executeUpdate;

        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();

                if (connection != null)
                    connection.close();
                logger.debug("execute close method");
            } catch (SQLException e){
                logger.error(e.getMessage());
            }
        }
        return 0;
    }

    @Override
    public int remove(int deptId) {
        String sql = "delete from department where deptId = ?";
        //获取数据库连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            //通过Connection得到预处理SQL语句的对象
            preparedStatement = connection.prepareStatement(sql);

            //因为SQL语句有参数，为SQL语句的参数赋值
            preparedStatement.setInt(1,deptId);

            //执行DML操作
            int executeUpdate = preparedStatement.executeUpdate();
            logger.debug("执行结果：" + executeUpdate);
            return executeUpdate;

        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();

        } finally {
            //关闭连接，释放资源
            try {
                if (preparedStatement != null)
                    preparedStatement.close();

                if (connection != null)
                    connection.close();
                logger.debug("execute close method");
            } catch (SQLException e){
                logger.error(e.getMessage());
            }
        }
        return 0;
    }

    @Override
    public int update(Department department) {
        String sql = "update department set deptName=?,deptAddress=? where deptId = ?";
        //获取数据库连接
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);

            //通过Connection得到预处理SQL语句的对象
            preparedStatement = connection.prepareStatement(sql);

            //因为SQL语句有参数，为SQL语句的参数赋值
            preparedStatement.setString(1,department.getDeptName());
            preparedStatement.setString(2,department.getDeptAddress());
            preparedStatement.setInt(3,department.getDeptId());


            //执行DML操作
            int executeUpdate = preparedStatement.executeUpdate();
            logger.debug("执行结果：" + executeUpdate);
            return executeUpdate;

        } catch (SQLException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null)
                    preparedStatement.close();

                if (connection != null)
                    connection.close();
                logger.debug("execute close method");
            } catch (SQLException e){
                logger.error(e.getMessage());
            }
        }
        return 0;
    }

    @Override
    public Department findById(int deptId) {
        String sql = "select deptId,deptName,deptAddress from department where deptid = ?";
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Department department = null;

        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            pstmt = connection.prepareStatement(sql);

            pstmt.setInt(1,deptId);

            rs = pstmt.executeQuery();

            if (rs.next()){
                int d_id = rs.getInt(1);
                String deptName = rs.getString(2);
                String deptAddress = rs.getString(3);

                department = new Department(d_id,deptName,deptAddress); //将数据库查询出的数据组件称为部门对象
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();

                if (pstmt != null)
                    pstmt.close();

                if (connection != null)
                    connection.close();
                logger.debug("execute close method");
            } catch (SQLException e){
                logger.error(e.getMessage());
            }
        }

        return department;
    }

    @Override
    public List<Department> queryAll(int pageIndex, int pageSize) {
        String sql = "select deptId,deptName,deptAddress from department limit ?,? ";
        Connection connection = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<Department> list = new ArrayList<>();

        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            pstmt = connection.prepareStatement(sql);

            //分页
            pstmt.setInt(1,(pageIndex - 1) * pageSize);
            pstmt.setInt(2,pageSize);

            rs = pstmt.executeQuery();

            while (rs.next()){
                int d_id = rs.getInt(1);
                String deptName = rs.getString(2);
                String deptAddress = rs.getString(3);

                Department department = new Department(d_id,deptName,deptAddress); //将数据库查询出的数据组件称为部门对象
                list.add(department); //每次循环将组建的对象添加到集合中
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null)
                    rs.close();

                if (pstmt != null)
                    pstmt.close();

                if (connection != null)
                    connection.close();
                logger.debug("execute close method");
            } catch (SQLException e){
                logger.error(e.getMessage());
            }
        }
        return list;
    }
}
