package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class CarRacing {

    public record GameResult(List<Progression> progressions, List<Car> winners) {

    }

    public record Progression(List<CarProgression> cars) {

    }

    public record CarProgression(Car car, int position) {

        public String getName() {
            return car.getName();
        }

    }


    final List<Car> cars;
    final int gameCount;

    public CarRacing(List<Car.Name> carNames, int gameCount) {
        this.cars = carNames.stream().map(this::createCar).toList();

        this.gameCount = gameCount;
    }

    protected Car createCar(Car.Name name) {
        ObstaclesAhead obstacles = new ObstaclesAhead.ByRandom();
        Environment environment = new Environment(obstacles);

        return new Car(environment, name);
    }

    public GameResult playGame() {
        List<Progression> progressions = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            progressOnce();
            progressions.add(captureProgression());
        }

        List<Car> winners = getWinners();
        return new GameResult(progressions, winners);
    }

    /**
     * 게임을 1회 실행
     */
    private void progressOnce() {
        for (Car car : cars) {
            car.tryAdvance();
        }
    }

    private Progression captureProgression() {
        List<CarProgression> carProgressions = cars.stream()
                .map(car -> new CarProgression(car, car.getPosition()))
                .toList();

        return new Progression(carProgressions);
    }

    private List<Car> getWinners() {
        if (cars.isEmpty()) {
            return Collections.emptyList();
        }

        int max = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .getAsInt();

        return cars.stream()
                .filter(car -> car.getPosition() == max)
                .toList();
    }

}
