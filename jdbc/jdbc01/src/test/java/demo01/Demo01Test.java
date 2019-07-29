package demo01;

import org.junit.Test;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

public class Demo01Test {
    @Test
    public void testConnection(){
        Demo01 demo01 = new Demo01();
        Connection connection = demo01.getConnection();
        assertThat(connection,notNullValue());
    }

    @Test
    public void testAdd(){
        Demo01 demo01 = new Demo01();
        int i = demo01.executeUpdate("insert into tab_my_test values (8,'test8')");

        assertThat(i,greaterThan(0));
    }

    @Test
    public void testUpdate(){
        Demo01 demo01 = new Demo01();
        String name = "张三"; //;drop database mysql;
        int id = 8;
        int i = demo01.executeUpdate("update tab_my_test set name='"+name+"' where id = "+id);
        assertThat(i,greaterThan(0));
    }

    @Test
    public void testRemove(){
        Demo01 demo01 = new Demo01();
        int i = demo01.executeUpdate("delete from tab_my_test where id = 7");
        assertThat(i,greaterThan(0));
    }

    @Test
    public void testQuery(){
        Demo01 demo01 = new Demo01();
        List<Map<String, Object>> query = demo01.query("select id,name from tab_my_test");
        query.stream().forEach(t->{
            Object id = t.get("id");
            Object name = t.get("name");
            System.out.println("id:" + id + ",name:" + name);
        });
    }
}
