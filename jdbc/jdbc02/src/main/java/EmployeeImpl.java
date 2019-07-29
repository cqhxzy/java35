import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeImpl extends JDBCUtil implements IEmployee {
    @Override
    public int save(Employee employee) {
        return 0;
    }

    @Override
    public int update(Employee employee) {
        return 0;
    }

    @Override
    public int remove(int empId) {
        return 0;
    }

    @Override
    public List<Employee> queryAll() {
        String sql = "select empId,empName,empPosition,empHrId,empInDate,empSalary,empBonus,deptId from employee";
        List<Map<String, Object>> maps = super.queryAll(sql);
        IDepartMent iDepartMent = new DepartmentImpl();

        /*List<Employee> list = new ArrayList<>();
        for (Map<String, Object> map : maps) { //一个map的对象就是一行数据
            //Set<String> keys = map.keySet();
            *//*keys.stream().forEach(t -> {
                Object o = map.get(t);
                System.out.print("key:" + t + ",value:" + o);
            });
            System.out.println();*//*
            Employee employee = new Employee();

            int empId = (int) map.get("empId");
            String empName = (String) map.get("empName");
            String empPosition = (String) map.get("empPosition");
            Timestamp empInDate = (Timestamp) map.get("empInDate");
            Float empSalary = (Float) map.get("empSalary");
            Float empBonus = (Float) map.get("empBonus");

            Integer empHrId = (Integer) map.get("empHrId");
            Employee hr = new Employee(); //上级的对象
            hr.setEmpId(empHrId);

            int deptId = (int) map.get("deptId");
            Department department = iDepartMent.findById(deptId); //根据部门编号查询的部门的对象

            employee.setEmpId(empId);
            employee.setEmpName(empName);
            employee.setEmpPosition(empPosition);
            //将java.sql.Date转换为java.util.Date
            employee.setEmpInDate(new java.util.Date(empInDate.getTime()));
            employee.setEmpSalary(empSalary);
            employee.setBonus(empBonus);

            //部门
            employee.setDepartment(department);
            //上级
            employee.setHr(hr);

            list.add(employee);
        }*/

        List<Employee> list = maps.stream().map(map -> {
            Employee employee = new Employee();

            int empId = (int) map.get("empId");
            String empName = (String) map.get("empName");
            String empPosition = (String) map.get("empPosition");
            Timestamp empInDate = (Timestamp) map.get("empInDate");
            Float empSalary = (Float) map.get("empSalary");
            Float empBonus = (Float) map.get("empBonus");

            Integer empHrId = (Integer) map.get("empHrId");
            Employee hr = new Employee(); //上级的对象
            hr.setEmpId(empHrId);

            int deptId = (int) map.get("deptId");
            Department department = iDepartMent.findById(deptId); //根据部门编号查询的部门的对象

            employee.setEmpId(empId);
            employee.setEmpName(empName);
            employee.setEmpPosition(empPosition);
            //将java.sql.Date转换为java.util.Date
            employee.setEmpInDate(new Date(empInDate.getTime()));
            employee.setEmpSalary(empSalary);
            employee.setBonus(empBonus);

            //部门
            employee.setDepartment(department);
            //上级
            employee.setHr(hr);
            return employee;
        }).collect(Collectors.toList()); //将所有的Employee对象转换为集合

        return list;
    }

    @Override
    public List<Employee> queryByCondition(Float empSalary) {
        StringBuilder builder = new StringBuilder()
                .append("select e.empId,e.empName,e.empPosition,e.empHrId,e.empInDate,e.empSalary,e.empBonus,d.deptId,d.deptName,d.deptAddress ")
                .append(" from employee e inner join department d")
                .append(" on e.deptId = d.deptId")
                .append(" where e.empSalary > ?");
        List<Employee> list = new ArrayList<>();

        super.queryAll(builder.toString(), new ResultSetConsumer<Employee>(){

            @Override
            public Employee apply(ResultSet resultSet) throws SQLException {
                Employee employee = new Employee();

                int empId =  resultSet.getInt("empId");
                String empName = resultSet.getString("empName");
                String empPosition = resultSet.getString("empPosition");
                Timestamp empInDate = resultSet.getTimestamp("empInDate");
                Float empSalary = resultSet.getFloat("empSalary");
                Float empBonus = resultSet.getFloat("empBonus");

                Integer empHrId = resultSet.getInt("empHrId");
                Employee hr = new Employee(); //上级的对象
                hr.setEmpId(empHrId);

                Department department = new Department(); //根据部门编号查询的部门的对象
                department.setDeptId(resultSet.getInt("deptId"));
                department.setDeptName(resultSet.getString("deptName"));
                department.setDeptAddress(resultSet.getString("deptAddress"));

                employee.setEmpId(empId);
                employee.setEmpName(empName);
                employee.setEmpPosition(empPosition);
                //将java.sql.Date转换为java.util.Date
                employee.setEmpInDate(new Date(empInDate.getTime()));
                employee.setEmpSalary(empSalary);
                employee.setBonus(empBonus);

                //部门
                employee.setDepartment(department);
                //上级
                employee.setHr(hr);
                return employee;
            }

            @Override
            public void accept(Employee employee) {
                list.add(employee);
            }
        }, empSalary);
        return list;
    }
}
