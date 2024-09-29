package racingcar;

import racingcar.model.Car;
import racingcar.model.CreateObjectCars;
import racingcar.model.Move;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Main {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static Move move = new Move();

    public static void main(String[] args) {

        //자동차이름 문자열 입력받기
        String carNamesStr = inputView.askCarNames();

        //자동차 객체 생성
        CreateObjectCars creatObjectCars = new CreateObjectCars();
        List<Car> carList = creatObjectCars.createCarList(creatObjectCars.splitCarNames(carNamesStr));

        //시도할 횟수 입력받기
        int raceCount = inputView.askAttemptCount();

        inputView.closeScanner();

        //"실행결과" 출력
        inputView.startPrintOutput();

        //게임실행
        move.moveTurnAroundNTimes(raceCount, carList, inputView);

        //게임결과 출력
        outputView.PrintWhoIsWinner(carList);
    }
}
