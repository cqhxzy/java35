import java.util.List;

public interface IEmployee {
    int save(Employee employee);
    int update(Employee employee);
    int remove(int empId);
    List<Employee> queryAll();

    /**
     * 查询工资超过empSalary的员工信息
     * @param empSalary
     * @return
     */
    List<Employee> queryByCondition(Float empSalary);
}
