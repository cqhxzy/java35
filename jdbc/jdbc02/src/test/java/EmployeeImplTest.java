import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class EmployeeImplTest {

    private IEmployee iEmployee = new EmployeeImpl();

    @Test
    public void queryAll() {
        List<Employee> employees = iEmployee.queryAll();

        employees.stream().forEach(System.out::println);
    }

    @Test
    public void queryByCondition(){
        List<Employee> employees = iEmployee.queryByCondition(new Float(3000));
        employees.stream().forEach(System.out::println);
    }
}