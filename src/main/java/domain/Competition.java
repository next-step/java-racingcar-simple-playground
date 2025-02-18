package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

public class Competition {
    ArrayList<Car> cars = new ArrayList<>();

    public void joinCompetition(String name){
        cars.add(new Car(name, 0));
    }

    public void runRandomCompetition(){
        Random random = new Random();

        for (Car car : cars){
            car.moveCar(random.nextInt(10));
        }
    }

    public void runCompetition(int value){
        for (Car car : cars){
            car.moveCar(value);
        }
    }

    private int getPositionMax(){
        ArrayList<Integer> positionList = new ArrayList<>();

        for (Car car : cars){
            positionList.add(car.getPosition());
        }

        return Collections.max(positionList);
    }

    public ArrayList<Car> getWinners(){
        int maxPosition = getPositionMax();
        return cars.stream()
                .filter(car ->  car.getPosition() == maxPosition)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Car> getCars(){
        return cars;
    }
}
