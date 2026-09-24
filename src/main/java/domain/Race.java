package domain;

import dto.CarDto;
import java.util.List;
import numberGenerator.NumberGenerator;

public class Race {

    private final Cars cars;

    public Race(List<String> names) {
        this.cars = Cars.from(names);
    }

    public void start(NumberGenerator numberGenerator) {
        cars.moveAll(numberGenerator);
    }

    public List<String> getWinners() {
        return cars.getWinner();
    }

    public List<CarDto> getCarDtos() {
        return cars.getCarDtos();
    }


}
