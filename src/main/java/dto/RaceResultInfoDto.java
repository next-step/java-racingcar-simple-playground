package dto;

import domain.Car;

import java.util.List;

public class RaceResultInfoDto {

    private final List<String> winnerNames;

    private RaceResultInfoDto(List<Car> cars) {
        winnerNames = cars.stream()
                .map(Car::getName)
                .toList();
    }

    public static RaceResultInfoDto from(List<Car> winners) {
        return new RaceResultInfoDto(winners);
    }

    public List<String> getWinnerNames() {
        return List.copyOf(winnerNames);
    }

}
