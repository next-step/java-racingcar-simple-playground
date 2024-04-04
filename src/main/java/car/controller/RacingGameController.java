package car.controller;

import car.model.Car;
import car.model.CarName;
import car.model.GameNumber;
import car.model.RacingCars;
import car.view.Input;
import car.view.Output;

import java.util.ArrayList;
import java.util.List;

public class RacingGameController {

    private final Input input = new Input();
    private final CarName carName = new CarName();
    private RacingCars racingCars;
    private GameNumber gameNumber;
    private final Output output = new Output();
    public RacingGameController() {
        startGame();
        output.gameResultMessage();
        for(int i=0; i<gameNumber.getGameNumber(); i++){
            List<String> resultList = playGame(racingCars);
            output.gameStatus(resultList);
        }
        String winner = endGame(racingCars);
        output.gameWinner(winner);
    }

    private void startGame() {
        String carNames = input.inputCarName();
        carName.setCarName(carNames);
        racingCars = new RacingCars(carName.getCarNameList());

        gameNumber = new GameNumber(input.inputGameNumber());
    }
    private List<String> playGame(RacingCars racingCars){
        List<Car> carList = racingCars.getCarList();
        List<String> resultList = new ArrayList<>();
        for (Car car : carList) {
            car.move();
            String result = car.getName() + " : ";
            for(int i=0; i<car.getPosition(); i++){
                result += "-";
            }
            resultList.add(result);
        }
        return resultList;
    }
    private String endGame(RacingCars racingCars){
        List<Car> carList = racingCars.getCarList();
        int max = 0;
        String winner = "";
        for (Car car : carList) {
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
