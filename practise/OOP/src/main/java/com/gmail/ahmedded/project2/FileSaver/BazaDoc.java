package com.gmail.ahmedded.project2.FileSaver;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BazaDoc {
    //Polz data
    private String name;
    private String nickName;
    private String country;
    private String city;

    private int age;
    private int year;
    private int month;
    private int day;

    //File data
    private String nameFile;

    public int getLuckyDate() {
        return (year + month + day) / 3;
    }

    @Override
    public String toString() {
        return "My name is " + getName() +
                ", I am " + getAge() + " years old, and my nickname is " + getNickName() +
                ". I live in city " + getCity() + "and country " + getCountry() +
                ". Today's date: " + getDay() + "/" + getMonth() + "/" + getYear() +
                ". Lucky number for today: " + getLuckyDate();
    }
}
