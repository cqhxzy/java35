package field;

import entity.Food;
import entity.Student;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class Test3 {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        /*map.put("name", "牛肉干");
        map.put("price",10.88);
        Food food = initObj(Food.class, map);
        System.out.println(food);*/

        map.put("name", "张三");
        map.put("age", 18);

        Student student = initObj(Student.class, map);
        System.out.println(student);
    }

    /**
     * 这个方法可以为任意类中的属性赋值
     * 使用这个方法，必须要有无参构造
     * @param klass 要被赋值的类的Class
     * @param map   存放的要赋值的属性及其对应的值。 key:属性，value：值
     * @param <T>   初始化一个对象，并将map中的值付给对象
     * @return 返回<code>Class<T></code>对应的对象
     */
    private static <T> T initObj(Class<T> klass, Map<String,Object> map){
        try {
            //通过反射，调用无参构造方法实例化一个空的对象
            T t = klass.newInstance();

            for (String key : map.keySet()) { //key对应的是属性名
                Object value = map.get(key);
                //通过属性Field为obj对象中的属性赋值
                Field field = klass.getDeclaredField(key); //根据属性获取其Field的对象

                if (Modifier.isPrivate(field.getModifiers())) {
                    //如果属性为私有的，则不能为其赋值，应该先设置其可见性，再赋值。否则报错
                    field.setAccessible(true);
                }

                field.set(t,value);  //为属性赋值
            }
            return t;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
}
