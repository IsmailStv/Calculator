package Collection.map_interface;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashCodeEx1 {
    public static void main(String[] args) {
        Map<Student, Double> map = new HashMap<>();
        Student st1 = new Student("Zaur", "Tregulov", 3);
        Student st2 = new Student("Ismail", "Erkenov", 3);
        Student st3 = new Student("Mariya", "Ivanova", 1);
        Student st4 = new Student("Sergey", "Petrov", 4);
        Student st5 = new Student("Zaur", "Tregulov", 3);
        Student st6 = new Student("Igor", "Sidorov", 4);
        map.put(st1, 7.5);
        map.put(st2, 8.7);
        map.put(st3, 8.7);
        map.put(st4, 9.2);
        System.out.println(map);
//        boolean result = map.containsKey(st5);
//        System.out.println("result = " + result);
        System.out.println(st1.hashCode());
        System.out.println(st2.hashCode());
        System.out.println(st3.hashCode());
        System.out.println(st4.hashCode());
        System.out.println(st5.hashCode());
        System.out.println(st6.hashCode());
        for(Map.Entry<Student, Double> entry: map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        Map<Integer, String> map2 = new HashMap<>(16, 0.75f);
    }
}
class Student {
    String name;
    String surname;
    int course;

    public Student(String name, String surname, int course) {
        this.name = name;
        this.surname = surname;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, course);
    }
//    @Override
//    public int hashCode() {
//        return name.length() * 7 + surname.length() * 11 + course * 53;
//    }
}