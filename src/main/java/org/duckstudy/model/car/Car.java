package org.duckstudy.model.car;

import org.duckstudy.model.generator.RandomValueGenerator;
import org.duckstudy.view.OutputView;

public class Car {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int INITIAL_POSITION = 0;
    private static final int MIN_MOVEMENT_VALUE = 4;

    private final String name;
    private final RandomValueGenerator randomValueGenerator;
    private int position;

    public Car(String name, RandomValueGenerator randomValueGenerator, OutputView outputView) {
        validateCarName(name, outputView);

        this.name = name;
        this.randomValueGenerator = randomValueGenerator;
        this.position = INITIAL_POSITION;
    }

    private void validateCarName(String name, OutputView outputView) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(outputView.getCarNameExceptionMessage(MAX_NAME_LENGTH));
        }
    }

    public void move() {
        int randomValue = randomValueGenerator.generateRandomValue();
        if (randomValue >= MIN_MOVEMENT_VALUE) {
            ++position;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
