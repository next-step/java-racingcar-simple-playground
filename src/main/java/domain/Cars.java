package domain;

import dto.CarDto;
import java.util.List;
import numberGenerator.NumberGenerator;

public class Cars {
    private static final int MIN_CAR_COUNT = 2;
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars from(List<String> carNames) {
        validateCarNames(carNames);

        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();
        return new Cars(cars);
    }

    public void moveAll(NumberGenerator numberGenerator) {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }


    /**
     * 우승자 구하기
     */
    public List<String> getWinner() {
        int max = getMax();

        return cars.stream()
                .filter(car -> car.getDistance() == max)
                .map(Car::getName)
                .toList();
    }

    /**
     * 최대 거리 구하기
     */

    private int getMax() {

        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    private static void validateCarNames(List<String> carNames) {
        if (carNames == null || carNames.size() < MIN_CAR_COUNT) {
            throw new IllegalArgumentException("경주를 진행하려면 최소 2대 이상의 자동차가 필요합니다.");
        }

        long distinctCount = carNames.stream()
                .map(String::trim)
                .distinct()
                .count();

        if (distinctCount != carNames.size()) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public List<CarDto> getCarDtos() {
        return cars.stream()
                .map(car -> new CarDto(car.getName(), car.getDistance()))
                .toList();
    }
}
