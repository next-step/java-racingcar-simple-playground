package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final Cars cars;
    private final RandomNumber randomNumber;

    public RacingGame(Cars cars, RandomNumber randomNumber) {
        this.cars = cars;
        this.randomNumber = randomNumber;
    }

    public void carRaceOnce() {
        cars.move(randomNumber);
    }

    public List<Car> findWinners() {
        //최대위치인 차만 고르면됨
        int maxPosition = getMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars.getCars()) {
            winners.addAll(winnerOf(car, maxPosition)); //[학습] addAll은 다른 리스트의 요소를 통째로 추가하는 메서드임
        }
        return winners;
    }
    //add로 하면 값을 car로 받아야하는데 이때 우승자가 없는경우 반환값을 정하기 어려워 addAll 사용

    //winnerOf()는 우승자면 그 차 한 대짜리 리스트를, 아니면 빈 리스트를 반환만 합니다
    private List<Car> winnerOf(Car car, int maxPosition) {
        if (car.samePosition(maxPosition)) {
            return List.of(car);
        }

        return List.of();
    }

    private int getMaxPosition() {//다른데서 쓸일 없으니까 여기서만 쓰니까 private
        int maxPosition = 0;
        for (Car car : cars.getCars()) { //이게 최대위치 구한거
            maxPosition = Math.max(maxPosition, car.getCarPosition());
        }
        return maxPosition;
    }
}
