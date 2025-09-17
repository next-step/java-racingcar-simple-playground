import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Cars {
    private final List<Car> cars;
    private final Random random = new Random();

    public Cars(String[] carNames) {
        this.cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
        }
    }

    // 모든 자동차를 한 라운드 동안 이동시킵니다.
    public void moveAll() {
        for (Car car : cars) {
            car.move(random.nextInt(10));
        }
    }

    // 우승자를 찾아서 반환합니다.
    public List<String> findWinners() {
        int maxPosition = findMaxPosition();
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            // depth 2에 있던 if문을 메소드로 분리
            addWinnerIfPositionMatches(winners, car, maxPosition);
        }
        return winners;
    }

    // 우승자일 경우 리스트에 추가하는 로직을 분리한 메소드
    private void addWinnerIfPositionMatches(List<String> winners, Car car, int maxPosition) {
        if (car.getPosition() == maxPosition) {
            winners.add(car.getName());
        }
    }

    // 가장 멀리 이동한 자동차의 위치를 찾습니다.
    private int findMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            // depth 2에 있던 if문을 메소드로 분리
            maxPosition = updateMaxPosition(maxPosition, car);
        }
        return maxPosition;
    }

    // 현재 최대 위치와 자동차의 위치를 비교하여 더 큰 값을 반환하는 메소드
    private int updateMaxPosition(int currentMax, Car car) {
        if (car.getPosition() > currentMax) {
            return car.getPosition();
        }
        return currentMax;
    }

    // View가 데이터를 안전하게 사용할 수 있도록 Car 리스트의 복사본을 제공합니다.
    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
