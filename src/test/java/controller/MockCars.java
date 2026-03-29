package controller;

import model.Cars;

public class MockCars extends Cars {
    private int tryMovingEveryCarExecuteCount = 0;

    @Override
    public void tryMovingEveryCar(){
        tryMovingEveryCarExecuteCount++;
        super.tryMovingEveryCar();
    }
    public int getTryMovingEveryCarExecuteCount() {
        return tryMovingEveryCarExecuteCount;
    }

}
