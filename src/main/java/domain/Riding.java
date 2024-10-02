package domain;

import util.GoOrStopValidator;
import util.RandomValueCreator;

public class Riding {

    // Q : 아래 두 함수도 따로 클래스를 분리하는 것이 좋은 것인지...?
    public void ride(final Car car, final int randomValue) {
        if (isGoOrStop(randomValue)) {
            car.goForward();
        }
    }

    private boolean isGoOrStop(final int randomValue) {
        return GoOrStopValidator.validateGoOrStop(randomValue);
    }
}
