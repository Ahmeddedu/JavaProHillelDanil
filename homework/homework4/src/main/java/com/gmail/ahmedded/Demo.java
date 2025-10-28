package com.gmail.ahmedded;

public class Demo{

    public static void main(String[] args) {
        Customer customer = getCustomer(getData());

        String output = "Customer: " + customer.getName() + ", phone: " + customer.getPhone();

        getOutput(output);
    }

    public static String[] getData() {
        return new String[]{"Джавик мили", "+3805050505050505050"};
    }

    public static Customer getCustomer(String[] data) {
        return new Customer(data[0], data[1]);
    }

    public static void getOutput(String output) {
        System.out.println(output);
    }
}

