package mapper;

import java.util.List;
import model.Cars;
import model.dto.CarProgress;

public class CarToProgressMapper {
    private CarToProgressMapper() {
    }

    public static List<CarProgress> toProgress(Cars cars) {
        return cars.getCars().stream()
                .map(car -> new CarProgress(car.getName(), car.getPosition()))
                .toList();
    }
}
