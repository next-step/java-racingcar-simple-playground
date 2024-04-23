package org.duckstudy.model.car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.duckstudy.model.generator.Generator;
import org.duckstudy.view.OutputView;

public class Cars {

    private static final int INITIAL_POSITION = 0;

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = List.copyOf(cars);
    }

    public Cars(String[] carNames, Generator generator, OutputView outputView) {
        this.cars = createCars(carNames, generator, outputView);
    }

    private List<Car> createCars(String[] carNames, Generator generator, OutputView outputView) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName, generator, outputView));
        }
        return List.copyOf(cars);
    }

    public Cars playAndGetWinners(int repetitionNum, OutputView outputView) {
        for (int i = 0; i < repetitionNum; i++) {
            moveAll();
            outputView.printMessage(getPositions());
        }
        return calculateWinners();
    }

    private void moveAll() {
        for (Car car : cars) {
            car.move();
        }
    }

    private Cars calculateWinners() {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(INITIAL_POSITION);

        ArrayList<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        return new Cars(winners);
    }

    public List<Car> getCars() {
        return List.copyOf(cars);
    }

    public String getNames() {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    public String getPositions() {
        return cars.stream()
                .map(car -> car.getName() + " : " + "-".repeat(car.getPosition()))
                .collect(Collectors.joining("\n"))
                .concat("\n");
    }
}
