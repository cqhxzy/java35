package demo1;

/*静态导包*/
import org.junit.*;

import static org.junit.Assert.*;

public class UserDaoImplTest {
    /**
     * 测试save的测试方法
     */
    @Test
    public void saveTest(){
        UserDao userDao = new UserDaoImpl();
        userDao.save();
        fail("没有为什么，就是想报错");
    }

    /**
     * 测试捕获期望的异常
     */
    @Test(expected = java.lang.NullPointerException.class)
    public void exceptionTest(){
        throw new NullPointerException();
        //throw new ArrayIndexOutOfBoundsException();
    }

    @Before
    public void before(){
        System.out.println("before被执行了。。。。");
    }

    @After
    public void after(){
        System.out.println("after被执行了");
    }

    @BeforeClass
    public static void beforeClass(){
        System.out.println("beforeClass 被执行了");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("afterClass被执行了");
    }
}