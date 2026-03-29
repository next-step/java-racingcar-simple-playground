package model;

import java.util.*;

public class Cars {
    private final List<Car> racers;

    public Cars() {
       this.racers = new ArrayList<Car>();
    }
    public Cars(List<Car> racers) {
        this.racers = racers;
    }

    public boolean addCar(Car newCar) {
        return racers.add(newCar);
    }

    public void tryMovingEveryCar() {
        for (Car racer: this.racers) {
            racer.move();
        }
    }

    public List<String> getMaxDistanceCarNames() {
        int maxScore = getMaxScore();

        return this.racers.stream()
                .filter(racer -> racer.getDistance() == maxScore)
                .map(Car::getName)
                .toList();
    }

    public Map<String, List<Integer>> getRacerInfo() {
        Map<String, List<Integer>> result = new HashMap<String, List<Integer>>();
        Set<String> racerName = this.getRacerNames();

        for (String name: racerName) {
            result.put(name, new ArrayList<Integer>());
        }

        for (Car racer: racers) {
            String name = racer.getName();
            Integer distance = racer.getDistance();
            result.get(name).add(distance);
        }

        return result;
    }

    private Set<String> getRacerNames() {
        Set<String> result = new HashSet<String>();

        for (Car racer: racers) {
            result.add(racer.getName());
        }

        return result;
    }

    private int getMaxScore() {
        return this.racers.stream()
                .map(Car::getDistance)
                .max(Integer::compare)
                .orElse(-1);
    }
}
