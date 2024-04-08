package model;

import java.util.List;

public class Cars {
    private List<Car> cars;
    private List<Car> winners;

    public Cars(List<Car> cars){
        this.cars = cars;
    }

    // indent 고려하기
    public void getWinner(){
        int maxScore = getMaxScore();
        for(Car car : cars){
            if(car.getScore() == maxScore){
                winners.add(car);
            }
        }
    }

    public int getMaxScore(){
        int maxScore = 0;
        for(Car car : cars){
            if(car.getScore() > maxScore){
                maxScore = car.getScore();
            }
        }
        return maxScore;
    }
}
