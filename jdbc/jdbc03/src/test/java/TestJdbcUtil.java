import org.junit.Test;

import java.sql.Connection;

public class TestJdbcUtil {

    @Test
    public void test(){
        JDBCUtil util = new JDBCUtil();
        Connection connection1 = util.getConnection();
        Connection connection2 = util.getConnection();
        Connection connection3 = util.getConnection();
        Connection connection4 = util.getConnection();
        Connection connection5 = util.getConnection();
        util.closeAll(connection1,null,null);
        Connection connection6 = util.getConnection();
        System.out.println("-----------------------------------");

        util.closeAll(connection2,null,null);
        util.closeAll(connection3,null,null);
        util.closeAll(connection4,null,null);
        util.closeAll(connection5,null,null);
        util.closeAll(connection6,null,null);

    }
}
