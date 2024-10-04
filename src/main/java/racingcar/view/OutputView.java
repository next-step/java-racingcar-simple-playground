package racingcar.view;

import racingcar.model.Car;
import racingcar.model.WinnerCars;

import java.util.List;

public class OutputView {
    //<메소드>
    //우승자 출력
    public void PrintWhoIsWinner(String winningCars) {
        System.out.println(winningCars + "가 최종 우승했습니다.");
    }
}