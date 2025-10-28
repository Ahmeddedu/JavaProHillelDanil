package com.gmail.ahmedded.project3;

public class Baza {

    private String name;
    private int age;


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        String result = " Name :" + getName() + " Age :" + getAge();
        System.out.println(result);
        return result;
    }

}
