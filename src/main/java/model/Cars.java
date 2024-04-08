package model;

import java.util.List;

public class Cars {
    private List<Car> cars;
    private List<Car> winners;
    private int maxScore;

    public Cars(List<Car> cars){
        this.cars = cars;
    }

    public void getWinner(){
        for(Car car : cars){
            if(car.getScore() < maxScore){
                maxScore = car.getScore();
                winners.add(car);
            }
        }
    }
}
