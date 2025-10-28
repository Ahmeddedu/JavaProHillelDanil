package com.gmail.ahmedded;

/**
 * ===== ПОЛНЫЙ КОНСПЕКТ ООП В JAVA =====
 * Автор: ...
 *
 * 1. ООП — объектно-ориентированное программирование
 *    Принципы: Инкапсуляция, Наследование, Полиморфизм, Абстракция
 */

public class Java_OOP {

    public static void main(String[] args) {
        System.out.println("===== ООП КОНСПЕКТ =====");

        // ===== 1. Инкапсуляция =====
        Person p = new Person("Иван", 25);
        p.setAge(30);
        System.out.println(p.getName() + " — " + p.getAge() + " лет");

        // ===== 2. Наследование =====
        Employee e = new Employee("Петр", 40, "Менеджер");
        e.sayHello();

        // ===== 3. Полиморфизм =====
        Person poly = new Employee("Анна", 28, "Разработчик");
        poly.sayHello(); // будет вызван метод из Employee

        // ===== 4. Абстракция =====
        Animal cat = new Cat();
        cat.makeSound();

        // ===== 5. Интерфейсы =====
        Flyable bird = new Bird();
        bird.fly();

        // ===== 6. Композиция =====
        Car car = new Car(new Engine("V8"));
        car.start();

        // ===== 7. Анонимный класс =====
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Анонимный класс Runnable");
            }
        };
        r.run();

        // ===== 8. Record =====
        Point point = new Point(10, 20);
        System.out.println(point);

        System.out.println("===== КОНЕЦ ООП КОНСПЕКТА =====");
    }
}

/* ======================================================
 * 1. Инкапсуляция
 * ====================================================== */
class Person {
    private String name; // приватные поля
    private int age;

    public Person(String name, int age) { // конструктор
        this.name = name;
        this.age = age;
    }

    // Геттеры и сеттеры (контроль доступа)
    public String getName() {
        return name;
    }
    public void setName(String name) { this.name = name; }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if (age > 0) { this.age = age; }
    }

    public void sayHello() {
        System.out.println("Привет! Я " + name);
    }
}

/* ======================================================
 * 2. Наследование
 * ====================================================== */
class Employee extends Person {
    private String position;

    public Employee(String name, int age, String position) {
        super(name, age); // вызов конструктора родителя
        this.position = position;
    }

    @Override
    public void sayHello() { // Переопределение метода
        System.out.println("Привет! Я " + getName() + ", моя должность: " + position);
    }
}

/* ======================================================
 * 3. Абстракция
 * ====================================================== */
abstract class Animal {
    public abstract void makeSound(); // абстрактный метод
    public void sleep() { System.out.println("Животное спит"); }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("Мяу");
    }
}

/* ======================================================
 * 4. Интерфейсы
 * ====================================================== */
interface Flyable {
    void fly();
}

class Bird implements Flyable {
    @Override
    public void fly() {
        System.out.println("Птица летит");
    }
}

/* ======================================================
 * 5. Композиция
 * ====================================================== */
class Engine {
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public void start() { System.out.println("Двигатель " + type + " запущен"); }
}

class Car {
    private Engine engine; // композиция

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start() {
        engine.start();
        System.out.println("Машина поехала");
    }
}

/* ======================================================
 * 6. Record (Java 16+)
 * ====================================================== */
record Point(int x, int y) {}

/* ======================================================
 * 7. SOLID (кратко)
 *
 * S — Single Responsibility
 * O — Open/Closed
 * L — Liskov Substitution
 * I — Interface Segregation
 * D — Dependency Inversion
 *
 * В Java это реализуется через:
 * - маленькие классы с одной ответственностью
 * - интерфейсы и абстракции
 * - наследование без нарушения замены типов
 * - разделение больших интерфейсов на маленькие
 * - зависимость от абстракций, а не конкретных реализаций
 * ====================================================== */

