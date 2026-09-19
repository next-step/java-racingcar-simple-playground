package domain;

import java.util.List;
import numberGenerator.NumberGenerator;

public class Race {

    private final Cars cars;
    private final NumberGenerator numberGenerator;

    public Race(String carNames, NumberGenerator numberGenerator) {
        cars = new Cars(List.of(carNames.split(",")));
        this.numberGenerator = numberGenerator;
    }

    public void start() {
        cars.moveAll(numberGenerator);
    }

    public List<String> getWinners() {
        return cars.getWinner();
    }


    public void getResult() {
        cars.printAll();
    }

}
