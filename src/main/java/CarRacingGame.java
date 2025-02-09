import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class CarRacingGame {
    private final List<Car> cars;
    private final int rounds;

    public CarRacingGame(List<String> carNames, int rounds) {
        this.cars = createCars(carNames);
        this.rounds = rounds;
    }

    private List<Car> createCars(List<String> carNames) {
        // 자동차 이름으로 car 객채 생성
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList()); // car 객체들을 리스트로 변환
    }

    public void race() {
        for (int i = 0; i < rounds; i++) {
            cars.forEach(Car::move);
            printRace();
        }
    }

//    라운드가 진행될 때마다 자동차들의 위치 출력
    private void printRace() {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getLocation()));
        }
        System.out.println();
    }

//    이동 거리가 가장 긴 자동차 리스트를 반환
    public List<Car> getWinners() {
        int maxLocation = findMaxLocation();
        return findWinners(maxLocation);
    }

//    그 최대 이동 거리를 구하는 메소드
    private int findMaxLocation() {
        return cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElse(0);
    }

//    앞에서 구한 최대 이동 거리를 통해 우승 자동차 리스트를 뽑는 메소드
    private List<Car> findWinners(int maxLocation) {
        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
