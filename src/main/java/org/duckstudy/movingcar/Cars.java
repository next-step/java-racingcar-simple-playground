package org.duckstudy.movingcar;

import java.util.ArrayList;
import java.util.List;
import org.duckstudy.generator.Generator;
import org.duckstudy.output.OutputView;

public class Cars {

    private static final int INITIAL_POSITION = 0;
    private final List<Car> cars;

    public Cars(int participantNum, String[] carNames, Generator generator) {
        List<Car> cars = createCars(participantNum, carNames, generator);
        this.cars = List.copyOf(cars);
    }

    private List<Car> createCars(int participantNum, String[] carNames, Generator generator) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < participantNum; i++) {
            cars.add(new Car(carNames[i], generator));
        }
        return cars;
    }

    public List<Car> play(int repetitionNum, OutputView outputView) {
        for (int i = 0; i < repetitionNum; i++) {
            moveAll();
            outputView.printPosition(this);
        }
        return calculateWinners();
    }

    private void moveAll() {
        for (Car car : cars) {
            car.move();
        }
    }

    private List<Car> calculateWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(INITIAL_POSITION);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }
}
