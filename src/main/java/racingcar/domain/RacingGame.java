package racingcar.domain;

import java.util.Random;
import java.util.Scanner;

import static racingcar.view.InputView.getUserCarList;
import static racingcar.view.InputView.getUserRaceNum;
import static racingcar.view.ResultView.printRaceResult;
import static racingcar.view.ResultView.printWinner;

public class RacingGame {

    public static void setRandomNum(int[] raceResult){
        Random random = new Random();
        for ( int j = 0 ; j < raceResult.length ; j++ ){
            int temp = random.nextInt(9);
            if ( temp >= 4 ) raceResult[j]++;
        }
    }

    public static int findMax(int[] raceResult){
        int max = 0;
        for (int j : raceResult) {
            if (j >= max) max = j;
        }
        return max;
    }

    public static void start(){
        String[] userCarList = getUserCarList();        // 입력하고 쉼표단위로 나눈 차 배열
        int raceNum = getUserRaceNum();                 // 경주 횟수 입력값
        int[] raceResult = new int[userCarList.length]; // 경주 결과
        System.out.println("실행 결과");
        for (int i = 0 ; i < raceNum ; i++ ){
            setRandomNum(raceResult);
            printRaceResult(userCarList, raceResult);
        }

        printWinner(findMax(raceResult), userCarList, raceResult);

    }

}
