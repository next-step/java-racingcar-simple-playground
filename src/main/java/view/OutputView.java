package view;

import model.Car;
import model.Cars;

import java.util.stream.Collectors;

public class OutputView {

    public static void printCarNamesInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public static void printTryCountInputMessage() {
        System.out.println("시도할 횟수는 몇회인가요?");
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printGameStartMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRoundResult(Cars cars) {
        System.out.println(getCarsPositionToString(cars));
        System.out.println();
    }

    public static void printWinners(Cars winners) {
        System.out.println(getWinnersToString(winners) + "가 최종 우승했습니다.");
    }

    public static String getCarsPositionToString(Cars cars) {
        return cars.getCars().stream()
                .map(car -> getCarPositionToString(car))
                .collect(Collectors.joining("\n"));
    }

    public static String getCarPositionToString(Car car) {
        return car.getName() + ": " + "-".repeat(car.getPosition());
    }

    public static String getWinnersToString(Cars winners) {
        return winners.getCars().stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }
}
