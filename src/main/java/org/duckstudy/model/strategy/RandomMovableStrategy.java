package org.duckstudy.model.strategy;

import org.duckstudy.model.generator.NumberGenerator;

public class RandomMovableStrategy implements MovableStrategy {

    private static final int MIN_MOVEMENT_VALUE = 4;

    private final NumberGenerator numberGenerator;

    public RandomMovableStrategy(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public boolean isMovable() {
        int randomValue = numberGenerator.generateNumber();
        return randomValue >= MIN_MOVEMENT_VALUE;
    }
}
