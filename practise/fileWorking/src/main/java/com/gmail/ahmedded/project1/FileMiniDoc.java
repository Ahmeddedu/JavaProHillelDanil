package com.gmail.ahmedded.project1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileMiniDoc {

    private static final String BAZE_PATH = "/Users/ahmedik/Documents/JavaProject/JavaProDaniil/BazaMaven/src/main/java/com/gmail/ahmedded/practise/fileWorking/";

    public static void main(String[] args){

        Scanner ClassicScanner = new Scanner(System.in);

        System.out.println("What is your name");
        String name = ClassicScanner.nextLine();

        System.out.println("What is your nickname");
        String nickname = ClassicScanner.nextLine();

        System.out.println("What is your favorite programing language");
        String programingLanguage = ClassicScanner.nextLine();

        try{
            File fileDoc= new File(BAZE_PATH + "MyDoc.txt");
            if (fileDoc.createNewFile()){
                System.out.println("Your file was made");
            } else {
                System.out.println("Your file was made Do you want to delete him ?");

                System.out.println("If you want to delete 1 or if you dont want delete 2");
                int choseDelete = ClassicScanner.nextInt();

                if(choseDelete == 1){
                    if(fileDoc.delete()){
                        System.out.println("File deleted");
                        System.exit(0);
                    } else {
                        System.out.println("Failed to delete file");
                        System.exit(0);
                    }
                }else{
                    System.out.println("Your file not download");
                    System.exit(0);
                }

            }

            FileWriter writer = new FileWriter(fileDoc, true);
            writer.write(("My name - ") + name + "\n");
            writer.write(("My nickName - ") + nickname + "\n");
            writer.write(("My love program language - ") + programingLanguage + "\n");

            writer.close();

            System.out.println("Your file was made do you want to make some text for you type 1 or no type 2 ");
            int choseDodat = ClassicScanner.nextInt();
            ClassicScanner.nextLine();
            if(choseDodat == 1){
                System.out.println("Type all you want");
                FileWriter appendWriter = new FileWriter(fileDoc, true);
                String appendwr = ClassicScanner.nextLine();
                appendWriter.write(appendwr + "\n");
                appendWriter.close();
            }else{
                System.out.println("Notging else");
            }

            Scanner fileScanner = new Scanner(fileDoc);
            System.out.println("\n What in file : ");
            while (fileScanner.hasNextLine()){
                String line = fileScanner.nextLine();
                System.out.println(line);
            }

        } catch (IOException e){
            System.out.println("Something wrong : " + e.getMessage());
        }

    }
}
