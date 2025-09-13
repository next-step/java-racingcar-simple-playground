package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameManage {
    List<Car> cars = new ArrayList<>();

    public void addCar (Car car){
        this.cars.add(car);
    }

    public void race (int round) {
        for (int i = 0 ; i < round;i++){
            for (Car car : cars){
                car.move();
            }
        }
    }

    public void findWinner() {
        int max = 0;
        for (Car car : cars) {
            if (max < car.getCarPosition()) {
                max = car.getCarPosition();
            }
        }

        for (Car car : cars){
            if (car.getCarPosition() == max){
                System.out.println(car.getCarName());
            }
        }
    }
}
