package com.gmail.ahmedded.project1;

public interface Trip {
    void startEngine();
    void goPoint();
    void endEngine();

    default void runTrip(){
        startEngine();
        goPoint();
        endEngine();
    }
}
