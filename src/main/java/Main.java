import view.InputView;

public class Main {
    public static void main(String[] args) {
        final var carNames = InputView.getCarNames();
        final var tryCount = InputView.getNumberOfRounds();

        CarSimulator carSimulator = new CarSimulator(carNames, tryCount);
        carSimulator.start();
    }
}
