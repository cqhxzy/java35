package demo01;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Method;

public class Demo01 {
    public static void main(String[] args) throws Exception {
        String str = "hello world";
        //System.out.println(str);

        Class<Student> claz = Student.class;
        Student student = claz.newInstance();
        Method setName = claz.getMethod("setName", String.class);
        setName.invoke(student,"张三");


        /*
        * java.lang.NoClassDefFoundError: 这个异常告诉我们，我们的项目缺少某些jar包的依赖
        * */
        BeanUtils.setProperty(student,"id",10001);

        System.out.println(student);
    }
}
