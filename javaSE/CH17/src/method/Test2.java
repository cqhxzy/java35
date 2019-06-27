package method;

import entity.Student;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) {
        Class<Student> studentClass = Student.class;

        try {
            Student student = studentClass.newInstance();
            //根据方法名获取方法
            Method setName = studentClass.getMethod("setName", String.class);//形参

            //得到方法以后，我们的目的是执行方法
            setName.invoke(student, "李四");//实参

            Method setAge = studentClass.getMethod("setAge", Integer.class);
            setAge.invoke(student,18);

            //System.out.println(student);
            Method getName = studentClass.getMethod("getName");
            Object invoke_getName = getName.invoke(student);//执行getName方法，会得到一个结果
            System.out.println("invoke_getName:" + invoke_getName);

            Method getAge = studentClass.getMethod("getAge");
            Object invoke_getAge = getAge.invoke(student);
            System.out.println("invoke_getAge:" + invoke_getAge);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
