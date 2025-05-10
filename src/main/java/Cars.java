import java.util.*;
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

    public List<Car> getCars() {
        return cars;
    }

}
