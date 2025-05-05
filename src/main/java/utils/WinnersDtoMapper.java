package utils;

import domain.Car;
import dto.WinnersDto;

import java.util.List;
import java.util.stream.Collectors;

public class WinnersDtoMapper {

    public static WinnersDto from(List<Car> winners) {
        List<String> names = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        return new WinnersDto(names);
    }
}
