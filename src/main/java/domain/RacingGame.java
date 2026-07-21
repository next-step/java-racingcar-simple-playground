package domain;
import java.util.Random;

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


    int getWinnerNumber(){

        int winner_number = 0;
        int max = findMax();

        for(int i = 0; i < cars.length; i++){
            if(max == cars[i].getLocation()){
                winner_number++;
            }
        }

        return winner_number;
    }


    public String[] getWinners(){

        String[] winners = new String[getWinnerNumber()];
        int k = 0;
        int max = findMax();

        for(int i = 0; i < cars.length; i++){
            if(max == cars[i].getLocation()){
                winners[k] = cars[i].getCarName();
                k++;
            }
        }

        return winners;
    }

    public void move(Car car) {
        int number = rd.nextInt(10);

        if(number >= 4){
            car.setLocation(car.getLocation() + 1);
            return;
        }
        car.setLocation(car.getLocation());
    }

    public void moveAllCar(){
        for (int i = 0; i < cars.length; i++) {
            move(cars[i]);
            System.out.println(cars[i].getCarName() + " : " + "-".repeat(cars[i].getLocation()));
        }
        System.out.println();
    }

    public void race(){
        System.out.println("실행 결과");
        for(int i = 0; i < tryCount; i++){
            moveAllCar();
        }
    }

}
