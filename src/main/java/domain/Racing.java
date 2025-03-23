package domain;

public class Racing {

    private final Cars cars;

    public Racing(Cars cars) {
        this.cars = cars;
    }

    public void playRound() {
        cars.move();
    }

    public Cars findWinners() {
        return cars.findCarsHasSamePosition(cars.getMaxDistance());
    }

}
