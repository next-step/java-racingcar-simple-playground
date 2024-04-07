package domain;

import exception.IllegalRandomVariableException;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static view.OutputView.printCarsInfo;

public class CarRace {

    private static List<Car> cars;
    private int tryCount;

    public CarRace(String[] names, int tryCount) {
        cars = new ArrayList<>();
        for(int i=0;i<3;i++) cars.add(new Car(names[i]));

        this.tryCount = tryCount;
    }

    /*
    우승자를 찾는 메서드
    1. 최고 거리를 구한다.
    2. 해당 거리에 해당하는 차들을 반환한다.
     */
    public List<Car> getWinners(){
        int max = 0;
        // 가장 멀리간 자동차의 길이 구하기
        for (Car car : cars) {
            max = Math.max(car.getDistance(), max);
        }
        int finalMax = max;
        return cars.stream().filter(car -> car.getDistance() == finalMax).toList();
    }

    /*
    레이스를 시작하는 메서드
     */
    public void raceStart(){

        for (int i = 0; i < tryCount; i++) {
            raceOneLap();

            // 도메인에서 실행 결과를 출력하도록하는게 맞는지??
            OutputView.printCarsInfo(cars);
        }
    }

    /*
    각 차마다 랜덤 숫자 여부에 따라 전진
     */
    private void raceOneLap() {
        for (Car car : cars) {
            int randomNumber = RandomValueGenerator.generate();
            car.moveOrStop(randomNumber);
        }
    }
}
