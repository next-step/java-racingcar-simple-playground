package domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> cars = new ArrayList<>();
    private EachRoundResult eachRoundResult = new EachRoundResult();

    public Racing(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> enrollCars(String[] carNames) {
        System.out.println("enrollcars 실행완료");
        for (String carName : carNames) {
            try {
                cars.add(new Car(carName));
            } catch (IllegalArgumentException e) {
                System.out.println(e);
            }
        }
        return cars;
    }

    public List<Car> eachCarRacing() {
        for (Car car : cars) {
            int randomNumber = (int) (Math.random() * 10);
            car.move(randomNumber);
        }
        return cars;
    }

    public List<List<Car>> startRacing(int count) {
        System.out.println("startRacing 실행완료");
        for (int i = 0; i < count; i++) {
            cars = eachCarRacing();
            eachRoundResult.addSnapShot(cars);
            System.out.println(i);
        }
        return eachRoundResult.getWholeSnapShot();
    }
}
