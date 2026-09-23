package controller;

import static domain.Cars.createCars;
import static view.InputView.readCarName;
import static view.InputView.readTryCount;
import static view.ResultView.printFinalWinners;
import static view.ResultView.printRound;

import domain.Cars;
import domain.DefaultRandomNumber;
import domain.RacingGame;

public class RacingController {

    public void run() {
        //자동차 이름 입력받기
        String[] carNameArray = readCarName();
        //자동차 생성시키기
        Cars carsList = createCars(carNameArray);
        //시도할 횟수 받기
        int tryCount = readTryCount();
        System.out.println();
        //시도 횟수만큼 경주시키기 (단, 경주할떄마다 값 출력하기)
        RacingGame racingGame = new RacingGame(carsList, new DefaultRandomNumber());
        raceCars(racingGame, carsList, tryCount);
        //최종 우승자 출력하기
        printFinalWinners(racingGame.findWinners());
    }

    //시도 횟수만큼 경주시키기 (단, 경주할떄마다 값 출력하기)
    private void raceCars(RacingGame racingGame, Cars carsList, int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            racingGame.carRaceOnce();
            //경주할때마다 값 출력하기
            printRound(carsList);
        }
    }
}
