package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.CreateObjectCars;
import racingcar.model.Move;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.*;

public class Controller {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private static Move move = new Move();

    public Map<String, Object> inputBeforeStart(){

        //자동차이름 문자열 입력받기
        String carNamesStr = inputView.askCarNames();

        //자동차 객체 생성
        CreateObjectCars creatObjectCars = new CreateObjectCars();
        List<Car> carList = creatObjectCars.createCarList(creatObjectCars.splitCarNames(carNamesStr));

        //시도할 횟수 입력받기
        int raceCount = inputView.askAttemptCount();

        //스캐너 반환
        inputView.closeScanner();

        // raceCount와 carList를 Map에 저장
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("raceCount", raceCount);
        resultMap.put("carList", carList);

        return resultMap;
    }

    public void outputAfterStart(Map<String, Object> params){

        //Map에서 필요정보 추출
        int raceCount = (int) params.get("raceCount");    // "raceCount"를 Map에서 가져옴
        List<Car> carList = (List<Car>) params.get("carList");

        //"실행결과" 출력
        inputView.startPrintOutput();

        //게임실행
        move.moveTurnAroundNTimes(raceCount, carList, inputView);

        //게임결과 출력
        outputView.PrintWhoIsWinner(carList);
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        Map<String, Object> gameParams= controller.inputBeforeStart();
        controller.outputAfterStart(gameParams);
    }
}
