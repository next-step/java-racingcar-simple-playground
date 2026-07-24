package domain;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    Random rd = new Random();

    int tryCount;
    Car[] cars;

    public RacingGame(String[] carNames, int tryCount){
        cars = new Car[carNames.length];
        this.tryCount = tryCount;

        for(int i = 0; i < carNames.length; i++){
            cars[i] = new Car(carNames[i]);
        }
    }

    int findMax(){

        int max = 0;

        for(int i = 0; i < cars.length; i++){
            max = Math.max(max, cars[i].getLocation());
        }

        return max;
    }


    public String[] getWinners(){

        List<String> winners = new ArrayList<>();
        int max = findMax();

        for(int i = 0; i < cars.length; i++){
            if (isWinner(cars[i], max)) {
                winners.add(cars[i].getCarName());
            }
        }

        return winners.toArray(new String[0]);
    }

    private boolean isWinner(Car car, int max) {
        return car.getLocation() == max;
    }

    public void eachRound(){
        for (int i = 0; i < cars.length; i++) {
            cars[i].move();
            System.out.println(cars[i].getCarName() + " : " + "-".repeat(cars[i].getLocation()));
        }
        System.out.println();
    }

    public void race(){
        System.out.println("실행 결과");
        for(int i = 0; i < tryCount; i++){
            eachRound();
        }
    }

}
