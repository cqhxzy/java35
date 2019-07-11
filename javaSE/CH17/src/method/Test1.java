package method;

import entity.Student;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        Class<Student> studentClass = Student.class;

        //获取Student类中所有的公共的方法，包括父类继承的
        Method[] methods = studentClass.getMethods();

        //获取Student类中所有本类的方法
        Method[] declaredMethods = studentClass.getDeclaredMethods();

        System.out.println("methods:" + methods.length);
        System.out.println("declaredMethods:" + declaredMethods.length);

        Arrays.stream(declaredMethods).forEach(t ->{
            String name = t.getName(); //获取方法名
            String modifier = Modifier.toString(t.getModifiers());//获取访问修饰符
            String returnType = t.getReturnType().getName();//获取方法的返回值类型
            int parameterCount = t.getParameterCount();//方法的参数列表的个数

            System.out.println("方法名：" + name);
            System.out.println("访问修饰符：" + modifier);
            System.out.println("返回值类型：" + returnType);
            System.out.println("参数个数：" + parameterCount);
            if (parameterCount > 0) {
                Class<?>[] parameterTypes = t.getParameterTypes(); //获取参数列表的类型
                Arrays.stream(parameterTypes).forEach(j-> //遍历
                    System.out.print(j.getName() + " ")
                );
            }
            System.out.println();
        });
    }
}
