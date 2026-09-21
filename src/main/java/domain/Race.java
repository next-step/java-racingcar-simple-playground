package domain;

import java.util.List;
import numberGenerator.NumberGenerator;

public class Race {

    private final Cars cars;

    public Race(String carNames) {
        cars = new Cars(List.of(carNames.split(",")));
    }

    public void start(NumberGenerator numberGenerator) {
        cars.moveAll(numberGenerator);
    }

    public List<String> getWinners() {
        return cars.getWinner();
    }


    public void getResult() {
        cars.printAll();
    }

}
