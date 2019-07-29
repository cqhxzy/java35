import java.util.List;

/**
 * Department 类对应的接口
 */
public interface IDepartMent {

    /**
     * 将department保存到数据库
     * @return
     */
    int save(Department department);

    /**
     * 根据主键删除数据
     * @param deptId
     * @return
     */
    int remove(int deptId);

    int update(Department department);

    /**
     * 根据ID查询
     * @param deptId
     * @return
     */
    Department findById(int deptId);

    /**
     * 分页实现查询全部数据
     * @param pageIndex 页码
     * @param pageSize 每页显示的条数
     * @return
     */
    List<Department> queryAll(int pageIndex,int pageSize);
}
