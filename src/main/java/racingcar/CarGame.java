package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarGame {
    List<Car> cars = new ArrayList<>();
    Output output = new Output();

    public void createCar(List<String> names) {
        for (String name : names) {
            cars.add(new Car(name));
        }
    }

    public void racing(List<NumberGenerator> random) {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).addDistance(random.get(i).generate());
        }
    }

    public List<String> winner() {
        List<String> winners = new ArrayList<>();
        int max = 0;

        for (Car car : cars) {
            int dis = car.getDistance();
            if (dis > max) {
                max = dis;
            }
        }

        if (max == 0) {
            throw new IllegalStateException("모든 차가 출발하지 않았습니다.");
        }

        for (Car car : cars) {
            int dis = car.getDistance();
            if (dis == max) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}