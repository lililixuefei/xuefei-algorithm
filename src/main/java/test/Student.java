package test;

/**
 * @description: test
 * @author: xuefei
 * @date: 2022/03/02 00:37
 */
public class Student {

    public static void main(String[] args) {
        Student student = new Student();
        student.setAge(18);
        student.setName("xuefei");

        Integer age1 = 10;
        student.setAge(-age1);
        System.out.println(student.age);


    }

    private Integer age;
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
