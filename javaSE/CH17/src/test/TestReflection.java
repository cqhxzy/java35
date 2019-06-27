package test;

import entity.Student;

/**
 * 反射的测试类
 */
public class TestReflection {
    public static void main(String[] args) {
        /*
        * 一个Class的对象就代表了一个类的结构
        * 通过Class中的方法就能够获知类的属性，方法，构造方法，父类，接口，注解
        *
        * 获取Class的三种方式
        * */

        //1.通过类名.class
        Class<Student> stu_class = Student.class;

        //2.通过类的对象.getClass() 方法获取Class的对象
        Student stu = new Student();
        Class<? extends Student> stuClass = stu.getClass();

        //3.通过Class类的静态方法获取Class的对象
        //第三种是最常用的方式，很多框架也是基于第三种方式来搭建的
        //Class.forName(类的完整路径)； 包名.类名构成了类的完整路径
        Class<?> forName = null;
        try {
            forName = Class.forName("entity.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //ctrl + d  复制当前行
        //ctrl + y  删除当前行
        System.out.println(stu_class);
        System.out.println(stuClass);
        System.out.println(forName);
    }
}
