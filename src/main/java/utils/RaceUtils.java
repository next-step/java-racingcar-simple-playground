package utils;

import domain.Car;

import java.util.ArrayList;
import java.util.List;

public class RaceUtils {

    public void playSingleTurn(List<Car> cars){
        for(Car car : cars){
            int randomDigit = new RandomDigitGenerator().generateRandomDigit();
            car.move(randomDigit);
        }
    }

    public List<Car> getWinner(List<Car> cars){
        List<Car> winners = new ArrayList<>();
        int maxPosition = getMaxPosition(cars);
        for (Car car : cars) {
            if (car.carPosition == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }

    public int getMaxPosition(List<Car> cars){
        int maxPosition = 0;
        for(Car car: cars) {
            maxPosition = Math.max(maxPosition, car.carPosition);
        }
        return maxPosition;
    }


}
