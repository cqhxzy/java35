import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

import static org.hamcrest.Matchers.*;

public class DepartmentImplTest {
    private IDepartMent departMent = new DepartmentImpl();

    @Test
    public void save() {
        //要保存到数据库的对象
        Department d = new Department(50,"研发部","武当山");
        int save = departMent.save(d);

        assertThat(save,greaterThan(0));
    }
    @Test
    public void update() {
        //要求改的对象
        Department d = new Department(50,"实施1部","冰火岛");
        int update = departMent.update(d);
        assertThat(update,greaterThan(0));
    }

    @Test
    public void remove() {
        int remove = departMent.remove(50);
        assertThat(remove,greaterThan(0));
    }


    @Test
    public void queryAll1(){
        List<Department> departments = departMent.queryAll(2, 3);
        departments.stream().forEach(System.out::println);
    }

    public void queryAll2(){

    }
}