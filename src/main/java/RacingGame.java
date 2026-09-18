public class RacingGame {
    private final Cars cars;
    private final NumberGenerator numberGenerator;

    public RacingGame(Cars cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public void race() {
        cars.move(numberGenerator);
    }
}
