package racingcar;

import racingcar.model.Car;
import racingcar.model.CreateObjectCars;
import racingcar.model.Move;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;
import java.util.Scanner;

public class Main {
    //<필드>
    private static InputView inputView = new InputView();
    private static OutputView outPutView = new OutputView();
    private static Move move = new Move();

    //<메인 메소드>
    public static void main(String[] args) {
        //스캐너 불러오기
        Scanner scanner = new Scanner(System.in);

        //자동차이름 문자열 입력받기
        String carNamesStr = inputView.askCarNames(scanner);

        //자동차 객체 생성
        CreateObjectCars creatObjectCars = new CreateObjectCars();
        List<Car> carList = creatObjectCars.createCarList(creatObjectCars.splitCarNames(carNamesStr));

        //시도할 횟수 입력받기
        int raceCount = inputView.askAttemptCount(scanner);

        //"실행결과" 출력
        inputView.startPrintOutput();

        //게임실행
        move.moveTurnAroundNTimes(raceCount, carList, inputView);

        //게임결과 출력
        outPutView.PrintWhoIsWinner(carList);

        //스캐너 반환하기
        scanner.close();
    }
}
