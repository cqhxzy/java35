package introspector;


import entity.Student;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * java的内省机制
 */
public class Test {
    public static void main(String[] args) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(Student.class);

            //创建一个空的对象
            Student stu = new Student();

            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            /*Arrays.stream(propertyDescriptors)
                    .forEach(t-> System.out.println(t.getName())); //获取Student中的所有的属性*/

            /*Arrays.stream(propertyDescriptors)
                    .filter(t -> !t.getName().equals("class"))
                    .forEach(t-> {
                        Method readMethod = t.getReadMethod();//获取getXXX方法
                        Method writeMethod = t.getWriteMethod();//获取setXXX方法
                        System.out.println("readMethod:" + readMethod.getName() + ",writeMethod:" + writeMethod.getName());
                    });*/
            Arrays.stream(propertyDescriptors)
                    .filter(t -> !t.getName().equals("class"))
                    .forEach(t -> {
                        Method writeMethod = t.getWriteMethod();//获取setXXX方法
                        try {
                            if (t.getName().equals("name")) {
                                writeMethod.invoke(stu, "王五");
                            }
                            if (t.getName().equals("age")) {
                                writeMethod.invoke(stu, 21);
                            }
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        }
                    });
            System.out.println(stu);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
    }
}
