package racingcar.view.text;

import java.util.List;
import racingcar.domain.Car;


public record ApplicationTextInput(List<Car.Name> carNames, int gameCount) {

}
