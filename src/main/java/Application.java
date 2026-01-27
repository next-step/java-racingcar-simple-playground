import domain.*;
import service.RacingCarGame;
import util.CarsFactory;
import view.InputView;
import view.OutputView;

import java.util.List;
import java.util.Scanner;

public final class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();

        CarsFactory carsFactory = new CarsFactory();
        Cars cars = new Cars(carsFactory.from(inputView.readCarNames()));
        int tryCount = inputView.readTryCount();

        Race race = new Race(cars);
        RandomNumberGenerator generator = new RandomNumberGeneratorImpl();
        WinnerSelector winnerSelector = new WinnerSelector();

        RacingCarGame game = new RacingCarGame(race, generator, winnerSelector, outputView);

        outputView.printStart();

        List<String> winners = game.play(tryCount);

        outputView.printWinners(winners);
    }
}
