
package Serializable;

import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        int countOfAnimals = 0;
        Animal[] animals = new Animal[0];

        ByteArrayInputStream dataInputStream = new ByteArrayInputStream(data);
        try {
            ObjectInputStream ois = new ObjectInputStream(dataInputStream);

            countOfAnimals = ois.readInt();
            animals = new Animal[countOfAnimals];

            for (int i = 0; i < countOfAnimals; i++) {
                Animal a = (Animal) ois.readObject();
                animals[i] = a;
            }

        } catch (Exception e) {
            throw new java.lang.IllegalArgumentException();
        }

        return animals;
    }
}

class Animal implements Serializable {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }
}
