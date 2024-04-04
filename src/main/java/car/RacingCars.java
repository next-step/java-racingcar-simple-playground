package car;

import java.util.ArrayList;
import java.util.List;

public class RacingCars {

    private final List<Car> carList = new ArrayList<>();

    public RacingCars(List<String> carNames){
        carNames.forEach(carName -> carList.add(new Car(carName)));
    }

    public List<Car> getCarList() {
        return carList;
    }

    public Car getWinner(){
        int max = 0;
        Car winner = carList.get(0);
        for (Car car : carList) {
            if(car.getPosition() >max){
                max = car.getPosition();
                winner = car;
            }
        }
        return winner;
    }

}
