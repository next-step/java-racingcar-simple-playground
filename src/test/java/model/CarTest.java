package model;

import common.FakeRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Random;

import static fixture.FakeNumber.MOVE_NUMBER;
import static fixture.FakeNumber.STOP_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @ParameterizedTest()
    @DisplayName("OK : 랜덤값이 4 이상일 시 움직임")
    @ValueSource(ints = {MOVE_NUMBER, 9})
    void carMove(int fixedValue){
        Car car = createCar(fixedValue);
        car.move();

        assertThat(car.getPosition()).isEqualTo(2);
    }

    @ParameterizedTest()
    @DisplayName("OK : 랜덤값이 4 미만일 시 움직이지 않음")
    @ValueSource(ints = {0, STOP_NUMBER})
    void carNotMove(int fixedValue){
        Car car = createCar(fixedValue);
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("ERROR : 이름 형식이 잘못됨")
    void InvalidNameCar(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car("", new Random()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car(" ", new Random()));
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Car("test12", new Random()));
    }

    private Car createCar(int fixedValue){
        return new Car("test1", new FakeRandom(List.of(fixedValue)));
    }
}
