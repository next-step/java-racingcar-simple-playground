package io.suhan.racingcar;

import io.suhan.racingcar.domain.Car;
import io.suhan.racingcar.domain.Game;
import io.suhan.racingcar.domain.RoundResult;
import io.suhan.racingcar.view.InputView;
import io.suhan.racingcar.view.ResultView;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names = InputView.getCarNames();
        int count = InputView.getTrialsCount();

        Game game = Game.of(count);
        game.getCarRegistry().registerCars(names);

        List<RoundResult> results = game.execute();
        List<Car> winners = game.getWinners();

        ResultView.printExecutionResult(results);
        ResultView.printWinners(winners);
    }
}
