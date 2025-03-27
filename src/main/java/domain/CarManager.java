package domain;

import repository.CarRepository;

import java.util.List;

public class CarManager {

    private final NumberGenerator numberGenerator;
    private final CarRepository carRepository;
    private final MoveStrategy moveStrategy;

    public CarManager(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
        this.carRepository = new CarRepository();
        this.moveStrategy = new MoveStrategy();
    }

    public void addCar(Car car) {
        carRepository.addCar(car);
    }

    public void moveIfCan() {
        List<Car> cars = carRepository.findAll();

        if (cars.isEmpty()) {
            throw new IllegalStateException("차량이 없습니다.");
        }

        for (Car car : cars) {
            int number = numberGenerator.getNumber();
            moveIfValid(car, number);
        }
    }

    private void moveIfValid(Car car, int number) {
        if (moveStrategy.canMove(number)) {
            car.move();
        }
    }

    public List<Car> findAllCar() {
        return carRepository.findAll();
    }

    public int getCarNumber() {
        return carRepository.getCarNumber();
    }
}
