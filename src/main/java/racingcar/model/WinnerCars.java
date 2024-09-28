package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class WinnerCars {
    //<필드>
    private List<Car> winningCars;

    //<메소드>
    //우승차 리스트 만들기
    public WinnerCars(List<Car> carList) {
        //max값 찾기
        int max=carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        //맥스값 가지고 있는 차 찾기
        List<Car> maxCarList = new ArrayList<>();
        for (Car car : carList) {
            if (car.getPosition() == max) {
                maxCarList.add(car);
            }
        }
        this.winningCars = maxCarList;
    }

    //<생성자>
    public List<Car> getWinningCars() {
        return winningCars;
    }
}