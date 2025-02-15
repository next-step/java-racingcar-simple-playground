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
        @DisplayName("Car �ν��Ͻ��� moveDistance�� 1 ������Ų��")
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
        @DisplayName("name�� �޾� ���ο� Car �ν��Ͻ��� ������ ��ȯ�Ѵ�")
        void createCarFromName() {
            Car car = Car.from(BASIC_CAR_NAME);
        }

        @ParameterizedTest
        @DisplayName("name�� ������ 5���ں��� �� ���ڿ��� �����ϸ� ���ܰ� �߻��Ѵ�")
        @ValueSource(strings = {"abcdef", "123456789", "Hello World"})
        void ifNameTooLongThenThrowException(String illegalName) {
            assertThatThrownBy(() -> Car.from(illegalName))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("name�� ������ ���� ���ڿ��� �����ϸ� ���ܰ� �߻��Ѵ�")
        void ifNameBlankThenThrowException() {
            String blankName = " ";

            assertThatThrownBy(() -> Car.from(blankName))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("name�� ������ �� ���ڿ��� �����ϸ� ���ܰ� �߻��Ѵ�")
        void ifNameEmptyThenThrowException() {
            String emptyName = "";

            assertThatThrownBy(() -> Car.from(emptyName))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

}