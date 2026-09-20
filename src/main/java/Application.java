import static domain.Cars.createCars;
import static view.InputView.readCarName;
import static view.InputView.readTryCount;
import static view.ResultView.printFinalWinners;
import static view.ResultView.printRound;

import domain.Cars;
import domain.DefaultRandomNumber;
import domain.RacingGame;

public class Application {

    public static void main(String[] args) {
        //자동차 이름 입력하여 생성시키기 --> 둘이 쪼개야할거같음

        //자동차 이름 입력받기
        String[] carNameArray = readCarName();
        //자동차 생성시키기
        Cars carsList = createCars(carNameArray);
        //시도할 횟수 받기
        int tryCount = readTryCount();
        System.out.println();
        //시도 횟수만큼 경주시키기 (단, 경주할떄마다 값 출력하기)
        raceCars(carsList, tryCount);
        //최종 우승자 출력하기
        printFinalWinners(carsList.findWinners());
    }

    //자동차 이름 입력받기
    //view.Input로 옮김

    //시도 횟수만큼 경주시키기 (단, 경주할떄마다 값 출력하기)
    private static void raceCars(Cars carsList, int tryCount) {
        DefaultRandomNumber defaultRandomNumber = new DefaultRandomNumber();
        RacingGame racingGame = new RacingGame(carsList, defaultRandomNumber);
        for (int i = 0; i < tryCount; i++) {
            racingGame.carRaceOnce();
            //경주할때마다 값 출력하기
            printRound(carsList);
        }
    }

    //라운드간 우승자 출력하기
    //최종 우승자 출력하기
    //view.Result로 옮김


}



