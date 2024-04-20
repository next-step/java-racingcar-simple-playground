package org.duckstudy.output;

import java.util.stream.Collectors;
import org.duckstudy.movingcar.Cars;

public class OutputView {

    public void printInputCarNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.");
    }

    public void printInputRepetitionNumMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultStartMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printPosition(Cars cars) {
        String position = cars.getCars()
                .stream()
                .map(car -> car.getName() + " : " + "-".repeat(car.getPosition()))
                .collect(Collectors.joining("\n"))
                .concat("\n");
        System.out.println(position);
    }

    public void printWinnerNames(String winnerNames) {
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }
}
