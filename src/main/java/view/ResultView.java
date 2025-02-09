package view;

import java.util.Arrays;

import domain.RacingGame;
import objectTmp.Car;

public class ResultView {
    public static void printWinners(Car[] winner){
        RacingGame.print(RacingGame.getLocate());
        String winNames = Arrays.stream(winner)
                                .map(Car::getName)
                                .reduce((a, b) -> a + ", " + b)
                                .orElse("");
        System.out.println(winNames + "가 최종 우승했습니다.");
    }

}
