import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameResult {
    private final Cars cars; //참가한 자동차들

    public GameResult(Cars cars) {
        this.cars = cars;
    }

    //이동된 자동차들의 최대위치 구하기
    private int getMaxPosition() {
        return cars.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    //우승 자동차 목록
    public List<Car> getWinners() {
        int max = getMaxPosition();
        return cars.getCars().stream()
                .filter(car -> car.getPosition() == max)
                .collect(Collectors.toList());
    }

    //우승 자동차 이름 목록
    public List<String> getWinnerNames() {
        return getWinners().stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    //우승 자동차의 수
    public int getWinnerCount() {
        return getWinners().size();
    }
}


