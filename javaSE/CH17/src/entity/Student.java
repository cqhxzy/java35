package entity;

import java.util.Objects;

/**
 * 一个学生的实体类
 */
public class Student {
    //shift + enter  使光标移动到下一行
    private String name;
    private Integer age;

    //alt + insert

    public Student() {
        System.out.println("Student类的无参构造方法被执行了");
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
        System.out.println("Student类的有参构造方法被执行了");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) &&
                Objects.equals(age, student.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("setName被执行了");
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
        System.out.println("setAge被执行了");
    }
}
