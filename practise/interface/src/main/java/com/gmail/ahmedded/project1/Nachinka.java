package com.gmail.ahmedded.project1;

public class Nachinka implements Trip{
    private String fuel;
    private String light;
    private String wheel;
    private boolean engine;

    public Nachinka(String fuel, String light, String wheel, boolean engine) {
        this.fuel = fuel;
        this.light = light;
        this.wheel = wheel;
        this.engine = false;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        fuel = fuel;
    }

    public String getLight() {
        return light;
    }

    public void setLight(String light) {
        light = light;
    }

    public String getWheel() {
        return wheel;
    }

    public void setWheel(String wheel) {
        wheel = wheel;
    }

    public boolean getEngine() {
        return engine;
    }

    public void setEngine(boolean engine) {
        engine = engine;
    }

    @Override
    public void startEngine(){
        engine = true;
        System.out.println("Engine start");
    }

    @Override
    public void goPoint(){
        if( getFuel() == "yes" && getEngine() == true){
            System.out.println("Brbrbrbrbrbr");
        } else {
            System.out.println("add fuel yes");
        }
    }

    @Override
    public void endEngine(){
        System.out.println("We are here");
    }

    @Override
    public String toString() {
        String result = "Fuel - " + getFuel() + " Light - " + getLight() + " Wheel - " + getWheel() + " Wheel - " + getWheel() + " engine - " + getEngine();
        System.out.println(result);
        return result;
    }


}
