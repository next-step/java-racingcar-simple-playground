
import domain.Car;
import domain.RacingGame;
import view.InputView;
import view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RacingGameController {

    InputView inputView;
    ResultView resultView;
    Scanner sc = new Scanner(System.in);

    public RacingGameController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void racingStart(){

        inputView.getCarsName();
        String carsNameInput = inputCarsName();

        inputView.getRaceCount();
        int raceCnt = inputRaceCnt();

        List <Car> cars = createCars(carsNameInput);
        RacingGame racingGame = new RacingGame(cars, raceCnt, resultView);
        racingGame.race();

        String winners = racingGame.getWinners();
        resultView.printWinners(winners);

    }

    public String inputCarsName(){
        String carsNameString = sc.nextLine();
        return carsNameString;
    }

    public int inputRaceCnt(){
        int raceCnt = sc.nextInt();
        return raceCnt;
    }

    public List<Car> createCars(String carsNameInput){
        return Arrays.stream(carsNameInput.split(",")).map(Car::new).toList();
    }

}
