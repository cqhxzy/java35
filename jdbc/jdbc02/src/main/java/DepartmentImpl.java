import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentImpl extends JDBCUtil implements IDepartMent{
    @Override
    public int save(Department department) {
        String sql = "insert into department (deptId,deptName,deptAddress) values(?,?,?)";
        return super.executeUpdate(sql,new Object[]{department.getDeptId(),department.getDeptName(),department.getDeptAddress()});
    }

    @Override
    public int remove(int deptId) {
        String sql = "delete from department where deptId = ?";
        return super.executeUpdate(sql,deptId);
    }

    @Override
    public int update(Department department) {
        String sql = "update department set deptName=?,deptAddress=? where deptId = ?";
        return super.executeUpdate(sql,new Object[]{department.getDeptName(),department.getDeptAddress(),department.getDeptId()});
    }

    @Override
    public Department findById(int deptId) {
        return null;
    }

    @Override
    public List<Department> queryAll(int pageIndex, int pageSize) {
        String sql = "select deptId,deptName,deptAddress from department limit ?,? ";
        int begin = ( pageIndex - 1 ) * pageSize;
        int end = pageSize;

        return super.queryAll(Department.class,sql,begin,end);
    }


}
