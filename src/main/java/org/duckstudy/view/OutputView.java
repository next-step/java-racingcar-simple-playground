package org.duckstudy.view;

import java.util.stream.Collectors;
import org.duckstudy.model.Cars;

public class OutputView {

    public void printInputCarNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printInputRepetitionNumMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultStartMessage() {
        System.out.println("\n실행 결과");
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

    public void printException(Exception e) {
        System.out.println(e.getMessage());
    }

    public String getCarNameExceptionMessage(int maxNameLength) {
        return String.format("자동차 이름은 1글자 이상 %d자 이하만 가능합니다.\n", maxNameLength);
    }

    public String getRepetitionNumExceptionMessage() {
        return "반복 횟수는 0보다 커야 합니다.\n";
    }
}
