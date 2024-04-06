import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarRace {

    /*
    우승자를 찾는 메서드
    1. 최고 거리를 구한다.
    2. 해당 거리에 해당하는 차들을 반환한다.
     */
    public static List<Car> selectWinners(List<Car> cars){
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
    public static List<Car> raceStart(int count, List<Car> cars){
        for (int i = 0; i < count; i++) {
            cars = raceOneLap(cars);
        }
        return cars;
    }

    /*
    각 차마다 랜덤 숫자 여부에 따라 전진
     */
    private static List<Car> raceOneLap(List<Car> cars) {
        for (Car car : cars) {
            car.moveOrStop(RandomValueGenerator.generate());
        }
        return cars;
    }
}
