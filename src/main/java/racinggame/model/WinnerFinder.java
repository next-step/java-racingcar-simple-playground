package racinggame.model;

import racinggame.model.car.Car;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerFinder {
    private final List<Car> cars;
    private final int moveCount;
    public WinnerFinder(List<Car> cars, int moveCount){
        this.cars = cars;
        this.moveCount = moveCount;
    }

    public void play(){
        for(int i=0;i<moveCount;i++){
            moveAllCars();
        }
    }
    public List<String> getWinners(){
        int maxDistance=maxDistance();
        return cars.stream().filter(car->car.getMovedDistance()==maxDistance).map(Car::getName).collect(Collectors.toList());
    }

    private void moveAllCars( ){
        for (Car car : cars) {
            car.move();
        }
    }
    private int maxDistance(){
        int max=0;
        for (Car car : cars) {
            max=Math.max(max,car.getMovedDistance());
        }
        return max;
    }
}
