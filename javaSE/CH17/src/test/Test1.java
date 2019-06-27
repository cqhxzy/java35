package test;

import entity.Student;

public class Test1 {
    public static void main(String[] args) {
        //通过反射创建类的对象
        //Student stu = new Student();//通过Student类的无参构造方法实例化对象

        //1.得到Student类的Class。三种方式
        try {
            Class<? extends Student> aClass = (Class<? extends Student>) Class.forName("entity.Student");

            Student o = aClass.newInstance(); //通过entity.Student类的无参构造方法实例化Student的对象
            if (o instanceof Student) {
                System.out.println("o 是Student的实例");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

    }
}