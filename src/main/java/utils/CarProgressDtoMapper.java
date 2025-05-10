package utils;

import domain.Car;
import dto.CarProgressDto;

import java.util.List;

public class CarProgressDtoMapper {

    public static List<CarProgressDto> from(List<Car> cars) {
        return cars.stream()
                .map(car -> new CarProgressDto(
                        car.getName().getValue(),
                        car.getPosition().getValue()
                ))
                .toList();
    }
}
