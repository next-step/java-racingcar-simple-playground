package view;

import domain.RacingCar;

public class ResultView {
    public static void result(String[] names, RacingCar racingcar) {
        System.out.println("실행 결과");
        for (int j = 0; j < names.length; j++) {
            System.out.println(names[j] + ":" + racingcar.car.get(names[j]));
        }
    }

    public static void printWinner(RacingCar racingCar) {
        System.out.println(racingCar.winner() + "가 최종 우승했습니다.");
    }

}