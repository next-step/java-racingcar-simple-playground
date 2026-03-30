package racingcar.domain;

import java.util.List;


public class TestCarRacing extends CarRacing {

    public TestCarRacing(List<Car.Name> carNames, int gameCount) {
        super(carNames, gameCount);
    }

    @Override
    protected Car createCar(Car.Name name) {
        ObstaclesAhead obstacles = new ObstaclesAhead.ByRandom(name.hashCode());
        Environment environment = new Environment(obstacles);

        return new Car(environment, name);
    }

}
