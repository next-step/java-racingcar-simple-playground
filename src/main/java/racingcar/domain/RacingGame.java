package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

public class Racing {
    private List<Car> carList;
    private List<Car> winners = new ArrayList<>();
    private int maxLocation = 0;
    private int moveTimes;
    private int carCount;

    public Racing(int numberOfCars, int moveTimes) {   //지정된 횟수만큼으로
        carList = new ArrayList<>(numberOfCars);
        this.moveTimes = moveTimes;
        this.carCount = numberOfCars;
    }

    public void addCar(String carName) {
        carList.add(new Car(carName));
    }

    public void startRacing() { //지정된 횟수만큼 lap함수를 호출해서 Racing 하는 함수
        for (int i = 0; i < moveTimes; i++) {
            startLap();
        }
        selectWinners();
        printWinners();
    }

    public void startLap() {    //전진 할지 말지 한번 도는게 lap
        int random;
        for (Car car : carList) {
            random = car.makeNum();
            car.moveCar(random);
        }
        printLapResult();
    }

    private void printLapResult() {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getLocation()));
        }
        System.out.println();
    }

    private int getMaxLocation() {    //1등의 location 뽑기
        for (Car car : carList) {
            if (car.getLocation() >= maxLocation) {
                maxLocation = car.getLocation();
            }
        }
        return maxLocation;
    }

    private List<Car> selectWinners() {   //우승자 뽑아서 winners에 우승한 Car 넣기
        int maxLocation = getMaxLocation();
        for (Car car : carList) {
            if (car.getLocation() == maxLocation) {
                winners.add(car);
            }
        }
        return winners;
    }

    private void printWinners() {
        StringJoiner sj = new StringJoiner(", ");

        for (Car car : winners) {
            sj.add(car.getName());
        }
        System.out.print(sj + "가 최종 우승했습니다.");
    }
}
