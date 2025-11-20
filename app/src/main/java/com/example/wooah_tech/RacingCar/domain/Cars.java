package com.example.wooah_tech.RacingCar.domain;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private List<Car> carList;

    public Cars(List<String> carNameList) {
        this.carList = carNameList.stream().map(Car::new).collect(Collectors.toList());
    }

    public List<String> getWinners(){
        int maxDistance = carList.stream().mapToInt(Car::getDistance).max().orElse(0);

        return carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Integer> getWinIndex(){
        int maxDistance = carList.stream().mapToInt(Car::getDistance).max().orElse(0);

        return carList.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(car -> carList.indexOf(car))
                .collect(Collectors.toList());
    }

    public HashMap<String, Integer> getCarDistanceMap(){
        return carList.stream()
                .sorted((c1, c2) -> Integer.compare(c2.getDistance(), c1.getDistance()))
                .collect(Collectors.toMap(
                        Car::getName,
                        Car::getDistance,
                        (existing, replacement) -> existing,
                        HashMap::new
                ));
    }

    public List<Car> getCarList() {
        return carList;
    }
}
