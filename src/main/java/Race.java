import java.util.ArrayList;
import java.util.List;

public class Race {
    private final List<RacingCar> cars;

    public Race(List<RacingCar> cars) {
        this.cars = new ArrayList<>(cars);
    }

    // 모든 자동차를 한 번씩 이동
    public void moveCars() {
        for (RacingCar car : cars) {
            car.move();
        }
    }

    public void race(int rounds) {
        for (int i = 0; i < rounds; i++) {
            moveCars();
        }
    }

    public List<RacingCar> getCars() {
        return cars;
    }

    // 자동차들 중 최대 위치를 반환
    private int getMaxPosition() {
        int max = 0;
        for (RacingCar car : cars) {
            if (car.getPosition() > max) {
                max = car.getPosition();
            }
        }
        return max;
    }

    // 최대 위치에 도달한 자동차 목록 반환
    public List<RacingCar> findWinners() {
        int maxPosition = getMaxPosition();
        List<RacingCar> winners = new ArrayList<>();

        for (RacingCar car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car);
            }
        }
        return winners;
    }
}
