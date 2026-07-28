package domain;

public class Play {
    private final Cars cars;
    private final NumberGenerator numberGenerator;

    public Play(Cars cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public void playRound() {
        cars.racingCars(numberGenerator);
    }
}