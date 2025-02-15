package model;

import java.util.List;
import java.util.stream.Collectors;

public interface FormattingGenerator {

    default String formatRaceStatus(List<Car> cars) {
        return cars.stream()
                .map(car -> car.getCars() + " : " + "-".repeat(car.getPosition()))
                .collect(Collectors.joining("\n"));
    }

    default String formatWinners(List<Car> winners) {
        return winners.stream()
                .map(Car::getCars)
                .collect(Collectors.joining(", ")) + "가 최종 우승했습니다.";
    }
}
