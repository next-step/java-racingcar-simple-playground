package utils;

import domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceUtils {

    public void playSingleTurn(List<Car> cars){
        for(Car car : cars){
            int randomDigit = new RandomDigitGenerator().generateRandomDigit();
            car.move(randomDigit);
        }
    }

    public List<Car> getWinner(List<Car> cars){
        int maxPosition = getMaxPosition(cars);
        return cars.stream().filter(car -> car.carPosition == maxPosition).collect(Collectors.toList());
    }

    public int getMaxPosition(List<Car> cars){
        int maxPosition = 0;
        for(Car car: cars) {
            maxPosition = Math.max(maxPosition, car.carPosition);
        }
        return maxPosition;
    }


}
