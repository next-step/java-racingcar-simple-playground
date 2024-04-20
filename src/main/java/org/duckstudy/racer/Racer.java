package org.duckstudy.racer;

import java.util.ArrayList;
import java.util.Arrays;
import org.duckstudy.movingcar.Car;
import org.duckstudy.movingcar.Cars;
import org.duckstudy.movingcar.RandomValueGenerator;

public class Racer {

    public static final int MAX_NAME_LENGTH = 5;
    private final Cars cars;
    private final int repetitionNum;

    public Racer(int participantNum, int repetitionNum, String[] nameList)
            throws IllegalArgumentException {
        if (validateNameList(nameList)) {
            throw new IllegalArgumentException("자동차 이름은 1글자 이상 5자 이하만 가능합니다.");
        }
        if (validateRepetitionNum(repetitionNum)) {
            throw new IllegalArgumentException("반복 횟수는 0보다 커야 합니다.");
        }
        this.cars = new Cars(makeCarList(participantNum, nameList));
        this.repetitionNum = repetitionNum;
    }

    private boolean validateNameList(String[] nameList) {
        return Arrays.stream(nameList).anyMatch(name -> name.isEmpty() || name.length() > MAX_NAME_LENGTH);
    }

    private boolean validateRepetitionNum(int repetitionNum) {
        return repetitionNum <= 0;
    }

    public ArrayList<Car> makeCarList(int participantNum, String[] nameList) {
        ArrayList<Car> carList = new ArrayList<>();
        for (int i = 0; i < participantNum; i++) {
            carList.add(new Car(new RandomValueGenerator(), nameList[i]));
        }
        return carList;
    }
}
