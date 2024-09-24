package view;

import domain.Car;
import domain.Cars;
import java.util.*;

public class OutputView {

    public static void printfResult() {
        System.out.println("실행 결과");
    }

    public static void printCarsInfo(final Cars cars) {
        for (final Car car : cars.getCars()) {
            final String name = car.getName();
            final String position = getPositionFormat(car.getPosition());
            System.out.printf("%s : %s\n", name, position);
        }
    }

    public static String getPositionFormat(final int position) {
        final StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < position; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public static void printResultOfWinner(final Cars winningCars) {
        final List<Car> cars = winningCars.getCars();
        final List<String> carNames = cars.stream() // car 리스트에서 각 자동차의 이름을 가져오기(stream)
                .map(Car::getName) // 각 car 객체에서 메서드 호출로 자동차 이름 가져오기
                .toList(); // 가져온 이름을 리스트로 변환
        final String winningCarNames = String.join(", ", carNames); // 우승한 이름을 출력 ","로 함께
        System.out.printf("%s가 최종 우승했습니다.\n", winningCarNames);
    }

}





//neo : -
//brie : -
//brown : -
//
//neo : --
//brie : -
//brown : --
//
//neo : ---
//brie : --
//brown : ---
//
//neo : ----
//brie : ---
//brown : ----
//
//neo : -----
//brie : ----
//brown : -----
//
//neo : -----
//brie : ----
//brown : -----
//
//neo, brown 가 최종 우승했습니다.