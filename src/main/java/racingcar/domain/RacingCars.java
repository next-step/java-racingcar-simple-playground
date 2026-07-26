package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingCars { //이름 리스트를 넘겨받으면 Car를 각각을 생성할수있게.
    private List<String> carNames;
    private List<Car> racingGameCars;

    public RacingCars(List<String> carNames) {
        this.carNames = carNames;
        this.racingGameCars = new ArrayList<>();
    }

    //리스트에 들어있는 이름들을 순회하면서 Car 객체를 생성하여 car리스트에 담아둔다.
    private void makeRacingCars() {
        for (String racingCarNames : carNames) {
            racingGameCars.add(new Car(racingCarNames));
        }
    }

    //racingGameCars getter
    public List<Car> getCarsList() {
        return racingGameCars;
    }
}
