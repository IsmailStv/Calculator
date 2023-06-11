package streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test2 {
    public static void main(String[] args) {
        Lambda.Student st1 = new Lambda.Student("Ivan",'m', 22, 3, 8.3);
        Lambda.Student st2 = new Lambda.Student("Nikolay",'m', 28, 2,6.4);
        Lambda.Student st3 = new Lambda.Student("Elena",'f', 19, 1, 8.9);
        Lambda.Student st4 = new Lambda.Student("Petr",'m', 35, 4,  7);
        Lambda.Student st5 = new Lambda.Student("Mariya",'f', 23, 3, 9.1);
        List<Lambda.Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        students = students.stream().filter(element
        -> element.getAge() > 22 && element.getAvgGrade() < 7.2)
                .collect(Collectors.toList());
        System.out.println(students);
    }
}
class Student {
    private String name;
    private char sex;
    private int age;
    private int course;
    private double avgGrade;

    public Student(String name, char sex, int age, int course, double avgGrade) {
        this.setName(name);
        this.setSex(sex);
        this.setAge(age);
        this.setCourse(course);
        this.setAvgGrade(avgGrade);
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", course=" + course +
                ", avgGrade=" + avgGrade +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }
}