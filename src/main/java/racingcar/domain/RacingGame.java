package racingcar.domain;

import racingcar.view.ResultView;
import java.util.ArrayList;
import java.util.List;

public class RacingGame { //리팩토링 예시에 맞춰서 클래스 이름 수정함
    private List<Car> carList;
    private List<Car> winners = new ArrayList<>();
    private int maxLocation = 0;
    private int moveTimes;
    private int carCount;

    public RacingGame(int numberOfCars, int moveTimes) {
        carList = new ArrayList<>(numberOfCars);
        this.moveTimes = moveTimes;
        this.carCount = numberOfCars;
    }

    public void addCar(String carName) {
        carList.add(new Car(carName));
    }

    public void race() {
        for (int i = 0; i < moveTimes; i++) {
            startLap();
        }
        selectWinners();
        ResultView.printWinners(winners); // 직접 호출하도록 수정
    }

    public void startLap() {
        int random;
        for (Car car : carList) {
            random = car.makeNum();
            car.moveCar(random);
        }
        ResultView.printLapResult(carList); // 직접 호출하도록 수정
    }

    private int getMaxLocation() {
        for (Car car : carList) {
            if (car.getLocation() >= maxLocation) {
                maxLocation = car.getLocation();
            }
        }
        return maxLocation;
    }

    private List<Car> selectWinners() {
        int maxLocation = getMaxLocation();
        for (Car car : carList) {
            if (car.getLocation() == maxLocation) {
                winners.add(car);
            }
        }
        return winners;
    }
}
