package model;

import common.FakeRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static fixture.FakeNumber.MOVE_NUMBER;
import static fixture.FakeNumber.STOP_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    private final List<String> carsNames = List.of("neo", "brie", "brown");

    @Test
    @DisplayName("OK : 자동차들을 조회함")
    void carsGetCars() {
        Cars cars = createCars();
        List<Car> carGroup = cars.getCars();

        assertThat(carGroup.size()).isEqualTo(3);
        IntStream.range(0, carGroup.size())
                .forEach(i -> assertThat(carGroup.get(i).getName())
                        .isEqualTo(carsNames.get(i)));
    }

    @Test
    @DisplayName("OK : 자동차들을 모두 움직임")
    void carsAllMove() {
        List<Integer> expectPositionResult = List.of(2, 2, 1);
        Cars cars = createCars();
        cars.allMove();

        IntStream.range(0, cars.getCars().size())
                .forEach(i -> assertThat(cars.getCars().get(i).getPosition())
                        .isEqualTo(expectPositionResult.get(i)));
    }

    @Test
    @DisplayName("OK : 자동차들 가장 멀리간 위치를 조회함")
    void carsFindMaxDistance() {
        Cars cars = createCars();
        cars.allMove();

        assertThat(cars.findMaxDistance()).isEqualTo(2);
    }

    private Cars createCars() {
        return new Cars(new FakeRandom(List.of(MOVE_NUMBER, MOVE_NUMBER, STOP_NUMBER)), carsNames);
    }
}
