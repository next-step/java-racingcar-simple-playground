package domain;

import java.util.List;
import numberGenerator.NumberGenerator;

public class Race {

    private final Cars cars;
    private final int COUNT;

    public Race(String carNames, int n) {
        cars = new Cars(List.of(carNames.split(",")));
        COUNT = n;
    }

    public void start(NumberGenerator numberGenerator) {
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < COUNT; i++) {
            cars.moveAll(numberGenerator);
            getResult();
        }
    }

    public List<String> getWinners() {
        return cars.getWinner();
    }


    public void getResult() {
        cars.printAll();
        System.out.println();
    }

}
