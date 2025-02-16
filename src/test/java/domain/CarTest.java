package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    private static final String BASIC_CAR_NAME = "CAR";

    @Nested
    class goForward {

        @Test
        @DisplayName("Car 인스턴스의 moveDistance를 1 증가시킨다")
        void increaseMoveDistance() {
            Car car = Car.from(BASIC_CAR_NAME);
            int prevMoveDistance = car.getMoveDistance();
            int expectedMoveDistance = prevMoveDistance + 1;

            car.goForward();
            int actualMoveDistance = car.getMoveDistance();

            assertThat(actualMoveDistance).isEqualTo(expectedMoveDistance);
        }

    }

    @Nested
    class from {

        @Test
        @DisplayName("name을 받아 새로운 Car 인스턴스를 생성해 반환한다")
        void createCarFromName() {
            Car car = Car.from(BASIC_CAR_NAME);
        }

        @ParameterizedTest
        @DisplayName("name의 값으로 5글자보다 긴 문자열을 전달하면 예외가 발생한다")
        @ValueSource(strings = {"abcdef", "123456789", "Hello World"})
        void ifNameTooLongThenThrowException(String illegalName) {
            assertThatThrownBy(() -> Car.from(illegalName))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("name의 값으로 공백 문자열을 전달하면 예외가 발생한다")
        void ifNameBlankThenThrowException() {
            String blankName = " ";

            assertThatThrownBy(() -> Car.from(blankName))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("name의 값으로 빈 문자열을 전달하면 예외가 발생한다")
        void ifNameEmptyThenThrowException() {
            String emptyName = "";

            assertThatThrownBy(() -> Car.from(emptyName))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

    @Nested
    class getName {

        @ParameterizedTest
        @DisplayName("Car 인스턴스의 name 필드를 반환한다")
        @ValueSource(strings = {"car1", "hello", "mycar"})
        void getNameFieldOfCarInstance(String carName) {
            Car car = Car.from(carName);

            String actualResult = car.getName();

            assertThat(actualResult).isEqualTo(carName);
        }

    }

    @Nested
    class getMoveDistance {

        @Test
        @DisplayName("Car 인스턴스의 moveDistance 필드(초기값 1)를 반환한다")
        void getMoveDistanceFieldOfCarInstance() {
            Car car = Car.from(BASIC_CAR_NAME);

            int expectedResult = 1;
            int actualResult = car.getMoveDistance();

            assertThat(actualResult).isEqualTo(expectedResult);
        }

    }

}