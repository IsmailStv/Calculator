package Generics;

import java.util.ArrayList;
import java.util.List;

public class GenericTest {
    public static void main(String[] args) {
        List<Animal> listOfAnimal = new ArrayList<>();
        listOfAnimal.add(new Animal(1));
        listOfAnimal.add(new Animal(2));

        List<Dog> listOfDog = new ArrayList<>();
        listOfDog.add(new Dog());
        listOfDog.add(new Dog());

        test(listOfDog);
        test(listOfAnimal);


//        Account<String> acc1 = new Account("2334", 5000); // id - число
//        String acc1Id = acc1.getId();
//        System.out.println(acc1Id);
//
//        Account<Integer> acc2 = new Account<Integer>(2345, 5000);
//        Integer acc2Id = acc2.getId();// id - число
//        System.out.println(acc2Id);
//        Accountable<String> acc1 = new Account("1235rwr", 5000);
//        Account acc2 = new Account("2373", 4300);
        Account<String> acc1 = new Account<String>("1235rwr", 5000);
        Account<String> acc2 = new Account<String>("2373", 4300);
        System.out.println(acc1.getId());
        System.out.println(acc2.getId());
    }
    private static void test(List<? extends Animal> list) {
        for(Animal animal : list) {
            System.out.println(animal);
            animal.eat();
        }
    }
}
interface Accountable<T> {
    T getId();
    int getSum();
    void setSum(int sum);
}
class Account<T> implements Accountable<T> {
    private T id;
    private int sum;
    Account(T id, int sum) {
        this.id = id;
        this.sum = sum;
    }
    public T getId() {
        return id;
    }
    public int getSum() {
        return sum;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }
}