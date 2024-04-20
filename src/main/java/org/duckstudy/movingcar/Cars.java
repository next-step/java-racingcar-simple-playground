package org.duckstudy.movingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.duckstudy.generator.Generator;

public class Cars {

    private static final int INITIAL_POSITION = 0;
    private final List<Car> cars;

    public Cars(int participantNum, String[] nameList, Generator generator) {
        List<Car> cars = createCars(participantNum, nameList, generator);
        this.cars = Collections.unmodifiableList(cars);
    }

    private List<Car> createCars(int participantNum, String[] nameList, Generator generator) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < participantNum; i++) {
            cars.add(new Car(nameList[i], generator));
        }
        return cars;
    }

    public List<Car> play(int repetitionNum) {
        for (int i = 0; i < repetitionNum; i++) {
            moveAll();
        }
        return calculateWinner();
    }

    private void moveAll() {
        for (Car car : cars) {
            car.move();
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    private List<Car> calculateWinner() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(INITIAL_POSITION);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }
}
