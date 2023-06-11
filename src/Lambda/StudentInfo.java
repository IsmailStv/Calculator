package Lambda;

import java.util.ArrayList;
import java.util.Collections;

public class StudentInfo {
    void testStudents(ArrayList<Student> a1, StudentChecks sc) {
        for(Student s : a1) {
            if(sc.check(s)) {
                System.out.println(s);
            }
        }
    }
//    void printStudentsOverGrade(ArrayList<Student> a1, double grade) {
//        for(Student s : a1) {
//            if(s.avgGrade > grade) {
//                System.out.println(s);
//            }
//        }
//    }
//    void printStudentsUnderAge(ArrayList<Student> a1, int age){
//        for(Student s : a1) {
//            if(s.age < age){
//                System.out.println(s);
//            }
//        }
//    }
//    void printStudentsMixCondition(ArrayList<Student> a1, int age, double grade, char sex) {
//        for(Student s : a1) {
//            if(s.age > age && s.avgGrade < grade && s.sex == sex) {
//                System.out.println(s);
//            }
//        }
//    }
}
class Test {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan",'m', 22, 3, 8.3);
        Student st2 = new Student("Nikolay",'m', 28, 2,6.4);
        Student st3 = new Student("Elena",'f', 19, 1, 8.9);
        Student st4 = new Student("Petr",'m', 35, 4,  7);
        Student st5 = new Student("Mariya",'f', 23, 3, 9.1);
        ArrayList<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);
        StudentInfo info = new StudentInfo();
//        Collections.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.course - o2.course;
//            }
//        });
        Collections.sort(students, (stud1, stud2) -> stud1.course - stud2.course);
        System.out.println(students);

//        info.testStudents(students, (Student s) -> {return s.age < 30;});
//        System.out.println();
//        info.testStudents(students, s -> s.avgGrade > 8);
//        StudentChecks sc = (Student s) -> {return s.avgGrade > 8;};
//        info.testStudents(students, sc);
//        System.out.println();
//        info.testStudents(students, (Student s) -> { return s.course > 2 && s.sex == 'm';});
    }
}
interface StudentChecks {
    boolean check(Student s);
}