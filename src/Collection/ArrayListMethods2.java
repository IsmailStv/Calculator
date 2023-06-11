package Collection;

import java.util.ArrayList;
import java.util.Objects;

public class ArrayListMethods2 {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 'm');
        Student st2 = new Student("Nikolay", 'm');
        Student st3 = new Student("Elena", 'f');
        Student st4 = new Student("Petr", 'm');
        Student st5 = new Student("Mariya", 'f');
        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);
        studentList.add(st4);
        studentList.add(st5);
        System.out.println(studentList);
        Student st6 = new Student("Mariya", 'f');
//        studentList.remove(st6);
        System.out.println(studentList);
        int index = studentList.indexOf(st6);
        System.out.println(index);
    }
}
class Student {
    private String name;
    private char sex;
    private  int age;
    private int course;
    private double aveGrade;

    public Student(String name, int course) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
        this.aveGrade = aveGrade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", aveGrade=" + aveGrade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return sex == student.sex && age == student.age && course == student.course && Double.compare(student.aveGrade, aveGrade) == 0 && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age, course, aveGrade);
    }
}
