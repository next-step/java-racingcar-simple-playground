package domain;

import java.util.*;

public class RacingcarGame {
    private final List<Car> carList;
    private int moveCount;

    public RacingcarGame(String[] nameArr, NumberGenerator numberGenerator) {
        this.carList = new ArrayList<>();
        putNamesToList(nameArr, numberGenerator);
    }

    /*
     * nameArr에서 이름을 하나씩 꺼내 domain.Car 객체 생성 후 carList에 add
     * */
    private void putNamesToList(String[] nameArr, NumberGenerator numberGenerator) {
        for (int i = 0; i < nameArr.length; i++) {
            Car car = new Car(nameArr[i], numberGenerator);
            carList.add(car);
        }
    }

    /*
    * 리펙터링: Application에서 moveCount를 변경하기 위해 추가
    * */
    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }
    /*
     * 리펙터링: Application에서 moveCount를 사용하기 위해 추가
     * */
    public int getMoveCount() {
         return this.moveCount;
    }

    /*
    * 리펙터링: Application에서 carList를 사용하기 위해 추가
    * */
    public List<Car> getCarList() {
       return new ArrayList<>(this.carList);
    }

    /*
     * Car를 한 번 이동시키기
     * */
    public void addDistance() {
        for (Car car : carList) {
            car.move();
        }
    }

    /*
     * 우승 자동차 구하기
     * */
    public List<Car> getWinner() {
        List<Car> winners = new ArrayList<>();
        int max = compare();

        for (Car car : carList) {
            putWinner(max, car, winners);
        }
        return winners;
    }

    // 차들간 누적거리 비교
    private int compare() {
        int max = 0; 
        for (Car car : carList) {
            max = maxDistance(max, car);
        }
        return max;
    }

    // Car의 누적거리가 max보다 크면 max값 갱신
    private int maxDistance(int max, Car car) {
        if (max < car.getTotalDistance()) {
            max = car.getTotalDistance();
        }
        return max;
    }

    // max와 누적거리가 같은 Car를 winner에 담기
    private void putWinner(int max, Car car, List<Car> winners) {
        if (max == car.getTotalDistance()) {
            winners.add(car);
        }
    }
}
