package view;

import dto.DtoList;
import dto.RacingCarDto;

import java.util.List;

public class ResultView {
    public static void result(DtoList cars) {
        System.out.println("\n실행 결과");

        for (RacingCarDto car : cars.getCars()) {
            System.out.println(car.getName()+ ":" + car.getPosition());
        }
    }

    public static void printWinner(List winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
