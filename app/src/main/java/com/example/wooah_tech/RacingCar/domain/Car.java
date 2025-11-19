package com.example.wooah_tech.RacingCar.domain;

import java.util.Random;

public class Car {
    private String name;
    private int distance;
    private Random random = new Random();

    public Car(String name){
        this.name = name.trim();
        distance = 0;
    }

    public void move(){
        if (randomNum() >= 4){
            distance ++;
        }
    }

    private int randomNum(){
        return random.nextInt(9) + 1;
    }
    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}