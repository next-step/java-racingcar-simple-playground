package car.controller;

import car.model.Car;
import car.model.CarName;
import car.model.GameNumber;
import car.model.RacingCars;
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
    public RacingGameController() {
        startGame();
        output.gameResultMessage();
        for(int i=0; i<gameNumber.getGameNumber(); i++){
            List<String> results = playGame(racingCars);
            output.gameStatus(results);
        }
        String winner = endGame(racingCars);
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
            car.move();
            String result = car.getName() + Constant.CAR_NAME_BORDER;
            for(int i=0; i<car.getPosition(); i++){
                result += Constant.CAR_POSITION_UNIT;
            }
            results.add(result);
        }
        return results;
    }
    private String endGame(RacingCars racingCars){
        List<Car> cars = racingCars.getCars();
        int max = 0;
        String winner = "";
        for (Car car : cars) {
            if(car.getPosition() >max){
                max = car.getPosition();
                winner = car.getName();
            }
            else if(max == car.getPosition()){
                winner += ", " + car.getName();
            }
        }
        return winner;
    }
}
