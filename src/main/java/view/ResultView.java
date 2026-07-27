package view;

import domain.RacingCar;
import domain.RacingGame;

public class ResultView {
    public static void result(RacingGame racingGame) {
        System.out.println("\n실행 결과");

        for (int i = 0; i < racingGame.getCars().size(); i++) {
            System.out.println(racingGame.getCars().get(i).getName()+ ":" + racingGame.getCars().get(i).getPosition());
        }
    }

    public static void printWinner(RacingGame racingGame) {
        System.out.println(racingGame.winner() + "가 최종 우승했습니다.");
    }
}
