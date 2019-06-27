package constructor;

import entity.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 通过构造函数实例化对象
 */
public class Test2 {
    public static void main(String[] args) {
        Class<Student> aClass = Student.class;
        try {
            //根据构造函数中的参数列表获取构造函数
            Constructor<Student> constructor = aClass.getConstructor();//获取无参构造

            Constructor<Student> constructor1 = aClass.getConstructor(String.class, Integer.class);//获取有参构造

            //通过构造函数实例化对象
            Student stu1 = constructor.newInstance();//根据构造函数的参数列表实例化对象

            Student stu2= constructor1.newInstance("张三", 19);

            System.out.println(stu1);
            System.out.println(stu2);
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
