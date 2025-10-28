package com.gmail.ahmedded.project2.FileSaver;

import lombok.SneakyThrows;

public class PolzSet {
    @SneakyThrows
    public static void main(String[] args) {

        Methodiki met = new Methodiki();

        System.out.println("Hello its program to make your local data :)");

        BazaDoc polz = met.collectData();

        System.out.println(polz);

        int rezForMakeFile = met.ask("If you want to make file with your data type 1 or if you dont want type 2");
        if(rezForMakeFile == 1){
            met.nameFile(polz);
            if (met.createFile(polz)) {
                // сразу пишем данные пользователя
                met.saveUserInfo(polz);
            }
        } else if (rezForMakeFile == 2) {
            System.out.println("Ok file not make it is your choise");
            System.exit(0);
        } else {
            System.out.println("You chose not 1 and 2 so file dont make ");
            System.exit(0);
        }

        if(met.hasAFile(polz)){
            System.out.println("File made you can see him");
        } else {
            System.out.println("Some problems with made file :(");
        }

        int rezForWriteFile = met.ask("If you want to make text in your file type 1 or if you dont want type 2");
        if(rezForWriteFile == 1){
            met.writeInFile(polz);
        } else if (rezForWriteFile == 2) {
            System.out.println("Ok file not make it is your choise");
            System.exit(0);
        } else {
            System.out.println("You chose not 1 and 2 so file dont make ");
            System.exit(0);
        }
    }
}
