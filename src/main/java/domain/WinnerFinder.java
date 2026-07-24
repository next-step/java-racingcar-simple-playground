package domain;

import java.util.ArrayList; // 우승자 여러 명 저장 가능
import  java.util.List;

public class WinnerFinder {
    public  List<String> findWinners(List<Car> cars) { // 자동치 목록 전달 받아 우승자 이름 목록 반환
        int maxPosition = findMaxPosition(cars); // 모든 자동차 중 가장 큰 위치 구함
        return collectWinners(cars, maxPosition);
    }
    private int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        return maxPosition;
    }
    private  List<String>collectWinners (List<Car> cars, int maxPosition) {
        List<String> winners = new ArrayList<>();

        for (Car car:cars) {
            addWinner(car, maxPosition, winners);
        }
        return winners;
    }
    private void addWinner(Car car, int maxPosition, List<String> winners) {
        if (car.isSamePosition(maxPosition)) {
            winners.add(car.getName());
        }
    }
}