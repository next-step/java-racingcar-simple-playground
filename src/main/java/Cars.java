import java.util.*;
import java.util.stream.IntStream;

public class Cars {
    //자동차 경주에 참가하는 자동차들의 집합
    private List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    //모든 자동차 roundCounts만큼 이동
    public void moveAll(int roundCounts) {
        for (Car car : cars) {
            IntStream.range(0, roundCounts)
                    .forEach(i -> car.move(RandomUtil.randomGenerator()));
        }
    }

    //모든 차를 1라운드씩 이동
    public void moveAllOneRound() {
        for (Car car : cars) {
            car.move(RandomUtil.randomGenerator());
        }
    }

    public List<Car> getCars() {
        return new ArrayList<>(cars); //캡슐화
    }

}
