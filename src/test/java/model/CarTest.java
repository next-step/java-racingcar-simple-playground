package model;

import common.FakeRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest()
    @DisplayName("OK : 랜덤값이 4 이상일 시 움직임")
    @ValueSource(ints = {4, 9})
    void carMove(int fixedValue){
        Car car = createCar(fixedValue);
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @ParameterizedTest()
    @DisplayName("OK : 랜덤값이 4 미만일 시 움직이지 않음")
    @ValueSource(ints = {0, 3})
    void carNotMove(int fixedValue){
        Car car = createCar(fixedValue);
        car.move();

        assertThat(car.getPosition()).isEqualTo(0);
    }

    private Car createCar(int fixedValue){
        return new Car("test", new FakeRandom(List.of(fixedValue)));
    }
}
