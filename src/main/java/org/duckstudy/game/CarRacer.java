package org.duckstudy.game;

import java.util.ArrayList;
import org.duckstudy.movingcar.Car;
import org.duckstudy.movingcar.CarMover;
import org.duckstudy.movingcar.RandomValueGenerator;

public class CarRacer {
    private final CarMover carMover;
    private final int participantNum;
    private final ArrayList<Car> carList = new ArrayList<>();
    private final int repetitionNum;

    public CarRacer() {
        this(new CarMover(new RandomValueGenerator()), 0, 0);
    }

    public CarRacer(CarMover carMover, int participantNum, int repetitionNum) {
        this.carMover = carMover;
        this.participantNum = participantNum;
        addCar(participantNum);
        this.repetitionNum = repetitionNum;
    }

    private void addCar(int participantNum) {
        for (int i = 0; i < participantNum; i++) {
            carList.add(new Car(i + 1 + "번째 자동차"));
        }
    }

    public ArrayList<Car> play() {
        for (int i = 0; i < repetitionNum; i++) {
            carMover.move(carList);
        }
        return calculateWinner(carList);
    }

    public ArrayList<Car> calculateWinner(ArrayList<Car> carList) {
        ArrayList<Car> winnerList = new ArrayList<>();
        long maxPosition = 0;

        for (Car car : carList) {
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
