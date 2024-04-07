package org.duckstudy.game;

import java.util.ArrayList;
import org.duckstudy.movingcar.Car;
import org.duckstudy.movingcar.CarMover;
import org.duckstudy.movingcar.RandomValueGenerator;

public class CarRacer {
    private static final RandomValueGenerator randomValueGenerator = new RandomValueGenerator();
    private static final CarMover carMover = new CarMover(randomValueGenerator);
    private final ArrayList<Car> carList = new ArrayList<>();
    private final int participantNum;
    private final int repetitionNum;

    public CarRacer(int participantNum, int repetitionNum) {
        this.participantNum = participantNum;
        this.repetitionNum = repetitionNum;

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

        for (int i = 0; i < carList.size(); i++) {
            maxPosition = getMaxPosition(winnerList, maxPosition, carList.get(i));
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
