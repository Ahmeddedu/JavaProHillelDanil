package com.gmail.ahmedded.project3;

public class Demo {
    public static void main(String[] args){
        Baza chel1 = new Baza();

        chel1.setName("Ahmedik");
        chel1.setAge(14);

        chel1.toString();

        Baza chel2 = new Baza();
        chel2.setName("Dura");
        chel2.setAge(25);

        chel2.toString();

        chel1.setName("AhmedZdoh");
        chel1.toString();

        Baza chel10 = new Baza();
        Baza chel20 = chel10;

        chel10.setName("Pikmi");
        chel20.setAge(29);

        chel10.toString();
        chel20.toString();

    }
}
