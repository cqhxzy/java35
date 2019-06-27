package constructor;

import entity.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        /*
        * java.reflect.Constructor的对象代表了一个构造方法
        * 通过Class类中的方法可以获得类中的Constructor
        * 构造方法的作用：实例化对象时执行的方法
        * 即使是反射实例化对象，依然必须通过构造函数作为入口
        * */
        Class<Student> klass = Student.class;

        //只能够获取public修饰的构造方法
        Constructor<?>[] constructors = klass.getConstructors();//获取Student类中所有的公共的构造方法

        //获取所有的构造方法
        Constructor<?>[] declaredConstructors = klass.getDeclaredConstructors();

       /* System.out.println("constructors.length:" + constructors.length);
        System.out.println("declaredConstructors.length:" + declaredConstructors.length);*/

       //遍历构造函数的对象数组
        for (int i = 0; i < constructors.length; i++) {
            Constructor<?> c = constructors[i];
            String name = c.getName();//获取构造方法的名称
            int m = c.getModifiers();
            String modifier = Modifier.toString(m); //得到访问修饰符

            int parameterCount = c.getParameterCount(); //获取当前构造方法的参数的个数

            System.out.println("name:" + name);
            System.out.println("modifier:" + modifier);
            System.out.println("parameterCount:" + parameterCount);

            if (parameterCount > 0) {
                //再去获取构造方法的参数列表
                Class<?>[] parameterTypes = c.getParameterTypes();
                System.out.println(name + "的参数列表：");
                Arrays.stream(parameterTypes).forEach(t -> System.out.println(t.getName()));
                System.out.println();
            }


            System.out.println();
        }

    }
}
