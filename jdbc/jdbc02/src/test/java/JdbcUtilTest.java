import org.junit.Test;

public class JdbcUtilTest {

    @Test
    public void test1(){
        JDBCUtil util = new JDBCUtil();
        String sql = "select deptId,deptName,deptAddress from department limit ?,? ";
        int pageIndex = 1; //当前页码
        int pageSize = 3; //每页显示的数目
        //util.queryAll(null,sql,(pageIndex - 1) * pageSize,pageSize);
    }
}
