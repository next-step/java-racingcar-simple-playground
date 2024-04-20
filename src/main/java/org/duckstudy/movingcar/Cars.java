package org.duckstudy.movingcar;

import java.util.ArrayList;
import java.util.List;

public class Cars {

    public static final int INITIAL_POSITION = 0;
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public ArrayList<Car> play(int repetitionNum) {
        for (int i = 0; i < repetitionNum; i++) {
            move();
        }
        return calculateWinner();
    }

    private void move() {
        for (Car car : cars) {
            car.move();
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private ArrayList<Car> calculateWinner() {
        ArrayList<Car> winnerList = new ArrayList<>();
        long maxPosition = INITIAL_POSITION;

        for (Car car : cars) {
            maxPosition = getMaxPosition(winnerList, maxPosition, car);
        }
        return winnerList;
    }

    private long getMaxPosition(ArrayList<Car> winnerList, long maxPosition, Car car) {
        if (maxPosition < car.getPosition()) {
            maxPosition = car.getPosition();
            winnerList.clear();
            winnerList.add(car);
            return maxPosition;
        }
        if (maxPosition == car.getPosition()) {
            winnerList.add(car);
        }
        return maxPosition;
    }
}
