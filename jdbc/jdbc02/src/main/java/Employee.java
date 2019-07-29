import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * 员工类
 */
public class Employee implements Serializable {
    private static final long serialVersionUID = 7041198163532312667L;
    private Integer empId;
    private String empName;
    private String empPosition;
    private Employee hr; //上级
    private Date empInDate;
    private Float empSalary;
    private Float Bonus;

    private Department department;//所属部门

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", empPosition='" + empPosition + '\'' +
                ", hr=" + hr +
                ", empInDate=" + empInDate +
                ", empSalary=" + empSalary +
                ", Bonus=" + Bonus +
                ", department=" + department +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empId == employee.empId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empId);
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    public Employee getHr() {
        return hr;
    }

    public void setHr(Employee hr) {
        this.hr = hr;
    }

    public Date getEmpInDate() {
        return empInDate;
    }

    public void setEmpInDate(Date empInDate) {
        this.empInDate = empInDate;
    }

    public Float getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Float empSalary) {
        this.empSalary = empSalary;
    }

    public Float getBonus() {
        return Bonus;
    }

    public void setBonus(Float bonus) {
        Bonus = bonus;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
