package view;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RaceOutputView {

    public void printGetCarNameMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printInvalidNameExceptionMessage() {
        System.out.println("5자 이하의 이름을 입력해주세요.");
    }

    public void printInvalidTurnExceptionMessage() {
        System.out.println("양의 정수의 값을 입력해주세요.");
    }

    public void printGetRaceTurnMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printStartShowResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printShowRaceStepsMessage(Car car) {
        System.out.println(car.getCarName() + " : " + "-".repeat(car.getCarPosition()));
    }

    public void printRaceOneTurn(List<Car> cars) {
        for (Car car : cars) {
            printShowRaceStepsMessage(car);
        }
        System.out.println();
    }

    public void printEndShowResultMessage(List<Car> winners) {
        String names = winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
        System.out.println(names + "가 최종 우승했습니다.");
    }

}
