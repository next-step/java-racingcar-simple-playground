package dto;

import domain.RacingCar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DtoList {
    private final List<RacingCarDto> cars = new ArrayList<>();

    public DtoList(List<RacingCar> racingCars) {
        for (RacingCar car : racingCars) {
            cars.add(new RacingCarDto(car));
        }
    }

    public List<RacingCarDto> getCars() {
        return Collections.unmodifiableList(cars);
    }

}
