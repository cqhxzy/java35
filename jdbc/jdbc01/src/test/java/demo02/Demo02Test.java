package demo02;

import org.junit.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class Demo02Test {

    @Test
    public void testInsert(){
        Demo02 demo02 = new Demo02();

        String sql = "insert into tab_my_test values (?,?)"; //DML操作
        //模拟数据
        int id = 10;
        String name = "王麻子";

       /* //打开连接
        Connection connection = demo02.getConnection();

        //PreparedStatement接口是一种预处理SQL语句的对象
        //在使用Statement接口时，如果sql语句中有参数，是直接将参数写到sql语句中
        //通过PreparedStatement实现预处理sql语句时，所有参数都用占位符表示。占位符通过?表示
        //在预处理sql语句时，再将占位符对应的参数，传递到预处理

        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);//预处理sql语句
            preparedStatement.setInt(1,id);
            preparedStatement.setString(2,name);

            int row = preparedStatement.executeUpdate();//执行DML操作的方法，返回数据库受影响的行数
            assertThat(row,greaterThan(0));
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

       //demo02.executeUpdate(sql,id,name);
        demo02.executeUpdate(sql,new Object[]{id,name});
    }

    @Test
    public void testUpdate(){
        Demo02 demo02 = new Demo02();

        String sql = "update tab_my_test set name= ? where id = ? "; //DML操作
        //模拟数据
        int id = 10;
        String name = "王大帅";

        demo02.executeUpdate(sql, name, id);
    }

    @Test
    public void testRemove(){
        Demo02 demo02 = new Demo02();

        String sql = "delete from tab_my_test where id = ?"; //DML操作
        //模拟数据
        int id = 10;

        demo02.executeUpdate(sql,id);
    }

    @Test
    public void testFindById(){
        String sql = "select id,name from tab_my_test where id = ?";
        int id = 8; //查询id为8的信息

        //获取连接
        Demo02 demo02 = new Demo02();
        Connection connection = demo02.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,id);

            rs = pstmt.executeQuery(); //得到结果集

            if (rs.next()) {
                int anInt = rs.getInt(1);
                String name = rs.getString(2);

                System.out.println("id:" + anInt + ",name:" + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            demo02.closeAll(connection,pstmt,rs);
        }
    }

    @Test
    public void testQueryByCondition(){
        Demo02 demo02 = new Demo02();
        double v = 2000;
        String sql = "select e.empId,e.empName,e.empPosition,e.empSalary,d.deptName " +
                        " FROM `employee` e" +
                        " inner join `department` d" +
                        " on e.deptId = d.deptId" +
                        " WHERE e.empSalary > ?" +
                        " ORDER BY e.empSalary";
        Connection connection = demo02.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setDouble(1,v);

            rs = pstmt.executeQuery(); //得到结果集

            while (rs.next()) { //循环次数不固定的情况用while
                int empId = rs.getInt(1);
                String empName = rs.getString(2);
                String empPosition = rs.getString(3);
                double empSalary = rs.getDouble(4);
                String deptName = rs.getString(5);

                String str = "empId:" + empId + ",empName:" + empName + ",empPosition:" + empPosition + ",empSalary:" + empSalary + ",deptName:" + deptName;
                System.out.println(str);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            demo02.closeAll(connection,pstmt,rs);
        }
    }
}