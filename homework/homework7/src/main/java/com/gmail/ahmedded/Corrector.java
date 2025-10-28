package com.gmail.ahmedded;

public class Corrector {

    public String handleData(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        int count = 1;
        for (String str : strs) {
            if (str.contains("b")) {
                str = str.replace("b", "o");
            }
            if (str.contains("n")) {
                str = str.replace("n", "i");
            }

            stringBuilder.append(count).append(") ").append(str).append("\n");
            count++;
        }
        return stringBuilder.toString();
    }
}
