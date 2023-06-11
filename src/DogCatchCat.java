public class DogCatchCat {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.sayHello();
        Dog dog = new Dog();
        dog.sayHello();
        dog.catchCat(cat);
    }

    public static class Cat {
        public void sayHello() {

            System.out.println("Мяу!");
        }
    }

    public static class Dog {
        public static void sayHello() {
            System.out.println("Гав!");
        }

        public static void catchCat(Cat catchCat) {
            System.out.println("Кошка поймана");
            sayHello();
            catchCat.sayHello();
        }
    }
}

