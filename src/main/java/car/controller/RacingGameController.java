package car.controller;

import car.model.*;
import car.view.Constant;
import car.view.InputView;
import car.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {

    private final InputView input = new InputView();
    private final CarName carName = new CarName();
    private RacingCars racingCars;
    private GameNumber gameNumber;
    private final OutputView output = new OutputView();
    private final Winner winner = new Winner();
    public RacingGameController() {
        startGame();
        output.gameResultMessage();
        for(int i=0; i<gameNumber.getGameNumber(); i++){
            List<String> results = playGame(racingCars);
            output.gameStatus(results);
        }
        endGame(racingCars);
        String winner = racingCars.getWinner();
        output.gameWinner(winner);
    }

    private void startGame() {
        String carNames = input.inputCarName();
        carName.setCarName(carNames);
        racingCars = new RacingCars(carName.getCarNames());

        gameNumber = new GameNumber(input.inputGameNumber());
    }
    private List<String> playGame(RacingCars racingCars){
        List<Car> cars = racingCars.getCars();
        List<String> results = new ArrayList<>();
        for (Car car : cars) {
            car.move(RandomNumberGenerator.generate());
            String result = car.getName() + Constant.CAR_NAME_BORDER;
            for(int i=0; i<car.getPosition(); i++){
                result += Constant.CAR_POSITION_UNIT;
            }
            results.add(result);
        }
        return results;
    }
    private void endGame(RacingCars racingCars){
        winner.findWinner(racingCars);
    }
}
