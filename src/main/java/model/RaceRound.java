package model;

import java.util.List;
import model.dto.CarRecord;

public record RaceRound(List<CarRecord> carRecords) {
    public RaceRound(Cars cars) {
        this(cars.getCars().stream()
                .map(car -> new CarRecord(car.getName(), car.getPosition()))
                .toList());
    }
}
