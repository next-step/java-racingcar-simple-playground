package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import exception.CarException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import utils.RandomValueGenerator;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("4 이상이면 전진하는지 확인한다.")
    void moveTest(int value) {
        Car car = new Car("포르쉐", () -> value);
        int beforeDistance = car.getDistance();
        car.moveOrStop();
        assertThat(car.getDistance()).isEqualTo(beforeDistance + 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 10, 11, 12})
    @DisplayName("4 미만이거나 10 이상이면 전진하지 않는지 확인한다.")
    void moveTestIfOverTen(int value) {
        Car car = new Car("제네시스", () -> value);
        car.moveOrStop();
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @DisplayName("자동차 이름이 6자 이상일 때, 자동차가 생성되지 않는지 확인한다.")
    @ParameterizedTest
    @ValueSource(strings = {"어코드하이브리드", "제네시스GV80", "현대팰리세이드", "기아스포티지"})
    void createCarIfNameOverSix(String carName) {
        // 자동차 생성 시 예외 발생하는 지 테스트
        assertThatThrownBy(() -> new Car(carName, new RandomValueGenerator()))
                .isInstanceOf(CarException.class)
                .hasMessageStartingWith("이름은 최소 ")
                .hasMessageEndingWith("자 입니다.");
    }

}
