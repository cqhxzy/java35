package field;

import entity.Student;

import java.lang.reflect.Field;

public class Test2 {
    public static void main(String[] args) {
        //我要获取Student类中的name属性
        Class<Student> studentClass = Student.class;

        try {
            //Field name = studentClass.getField("name"); //获取公共的属性
            Field name = studentClass.getDeclaredField("name"); //只要是Student中的属性都能够获取
            Class<?> type = name.getType();//获取属性的类型
            System.out.println(name.getName() + ",type:" + type.getName()); //输出属性的名字


            Field age = studentClass.getDeclaredField("age");
            Class<?> type1 = age.getType();
            System.out.println(age.getName() + ",type:" + type1.getName());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
