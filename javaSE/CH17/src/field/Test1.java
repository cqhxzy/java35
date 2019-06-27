package field;

import entity.Student;

import java.lang.reflect.Field;

public class Test1 {
    public static void main(String[] args) {
        Class<Student> aClass = Student.class;

        Field[] fields = aClass.getFields();//获取所有的公共的属性
        Field[] declaredFields = aClass.getDeclaredFields();//获取所有的属性

        System.out.println("fields.length:" + fields.length);
        System.out.println("declaredFields.length:" + declaredFields.length);
    }
}
