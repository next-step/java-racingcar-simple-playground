import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarRace {
    private List<Car> cars = new ArrayList<>();
    private int attempt;

    public CarRace(List<Car> cars, int attempt) {
        this.cars = cars;
        this.attempt = attempt;
    }

    public void raceStart() {
        Random random = new Random();
        for(int i = 0; i < attempt; i++) {
            for(Car car : cars) {
                int decision = random.nextInt(0, 9);
                car.move(decision);
            }
        }
    }

    public List<Car> findWinner() {
        List<Car> winners = new ArrayList<>();
        int furthestDistance = 0;
        for (Car car : cars) {
            if (car.getPosition() > furthestDistance) {
                furthestDistance = car.getPosition();
                winners.clear(); // 새로운 최고 기록이 나오면 이전 우승자 목록을 지운다
                winners.add(car);
            } else if (car.getPosition() == furthestDistance) {
                winners.add(car); // 같은 거리를 이동한 차도 우승자 목록에 추가
            }
        }
        return winners;
    }
}
