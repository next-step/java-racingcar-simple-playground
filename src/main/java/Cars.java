import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
    //자동차 경주에 참가하는 자동차들의 집합
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    //자동차 이동
    public void moveAll(int testRounds) {
        for (Car car : cars) {
            IntStream.range(0, testRounds)
                    .forEach(i -> car.move(RandomUtil.randomGenerator()));
        }
    }

    //이동된 자동차들의 최대위치 구하기
    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    //우승 자동차 목록
    public List<Car> getWinners() {
        int max = getMaxPosition();
        return cars.stream()
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
