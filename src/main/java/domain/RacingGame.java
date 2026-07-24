package domain;
import java.util.ArrayList;
import java.util.List;

public class RacingGame {

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


    public int[] eachRound(){
        int[] carLocations = new int[cars.length];

        for (int i = 0; i < cars.length; i++) {
            cars[i].move();
            carLocations[i] = cars[i].getLocation();
        }

        return carLocations;
    }

}
