package comparation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        Employee emp1 = new Employee(100, "Zayr", "Tregulov", 12345);
        Employee emp2 = new Employee(15, "Ivan", "Petrov", 6542);
        Employee emp3 = new Employee(123, "Ivan", "Sidorov", 8542);
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        System.out.println("Before sorting\n" + list);
        Collections.sort(list, new Salary());
        System.out.println("After sorting\n" + list);
    }
}
class Employee
//        implements Comparable <Employee>
{
    int id;
    String name;
    String surname;
    int salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }


////        return this.id - anotherEmp.id;
////        если id сделать Integer, то можно так:
////        return this.id.compareTo(anotherEmp.id);
////        если хотим сортировать по именам:
////        return this.name.compareTo(anotherEmp.name);
////        если хотим сортировать сначала по именам, а потом по фамилиям:
////        int res = this.name.compareTo(anotherEmp.name);
////        if(res == 0) {
////            res = this.surname.compareTo(anotherEmp.surname);
////        }
////        return res;
//    }
}
class IdComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        if(emp1.id == emp2.id) {
            return 0;
        } else if(emp1.id < emp2.id) {
            return -1;
        } else {
            return 1;
        }
    }
}
class NameComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.name.compareTo(emp2.name);
    }
}
class Salary implements Comparator<Employee> {

    @Override
    public int compare(Employee emp1, Employee emp2) {
        return emp1.salary - emp2.salary;
    }
}