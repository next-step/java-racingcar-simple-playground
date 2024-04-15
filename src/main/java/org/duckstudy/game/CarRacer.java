package org.duckstudy.game;

import java.util.ArrayList;
import java.util.Arrays;
import org.duckstudy.movingcar.Car;
import org.duckstudy.movingcar.CarMover;
import org.duckstudy.movingcar.RandomValueGenerator;

public class CarRacer {

    private static final int INTIAL_POSITION = 0;
    private final CarMover carMover;
    private final ArrayList<Car> carList = new ArrayList<>();
    private final int repetitionNum;

    public CarRacer() {
        this(new CarMover(new RandomValueGenerator()), 0, 3, new String[0]);
    }

    public CarRacer(CarMover carMover, int participantNum, int repetitionNum, String[] nameList)
            throws IllegalArgumentException {
        if (validateNameList(nameList)) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        if (validateRepetitionNum(repetitionNum)) {
            throw new IllegalArgumentException("시도 횟수는 0보다 커야 합니다.");
        }

        this.carMover = carMover;
        addCar(participantNum, nameList);
        this.repetitionNum = repetitionNum;
    }

    private boolean validateNameList(String[] nameList) {
        return Arrays.stream(nameList).anyMatch(name -> name.length() > 5);
    }

    private boolean validateRepetitionNum(int repetitionNum) {
        return repetitionNum <= 0;
    }

    private void addCar(int participantNum, String[] nameList) {
        for (int i = 0; i < participantNum; i++) {
            carList.add(new Car(nameList[i]));
        }
    }

    public ArrayList<Car> play() {
        for (int i = 0; i < repetitionNum; i++) {
            carMover.move(carList);
        }
        return calculateWinner(carList);
    }

    private ArrayList<Car> calculateWinner(ArrayList<Car> carList) {
        ArrayList<Car> winnerList = new ArrayList<>();
        long maxPosition = INTIAL_POSITION;

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
