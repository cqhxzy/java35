import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class IDepartmentImplTest {

    @Test
    public void queryAll() {
        IDepartMent departMent = new IDepartmentImpl();
        List<Department> departments = departMent.queryAll(2, 3);

        departments.stream().forEach(System.out::println);
    }
}