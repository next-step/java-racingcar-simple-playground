import domain.Car;
import domain.MoveCar;
import domain.Race;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Random;
import java.util.stream.IntStream;

public class carMoveTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4})
    @DisplayName("random 값이 4 이상일 경우 전진")
    void carMoveForward(int value) {
        //given
        Car car = new Car();
        MoveCar moveCar = new MoveCar();
        Race race = new Race();

        moveCar.check(value, car);

        // 전진했으면 통과
        //then
        Assertions.assertThat(car.getCurrentLocation())
                .withFailMessage("입력값: %d, 예상 결과: %d, 실제 결과: %d", value, 1, car.getCurrentLocation())
                .isEqualTo(1);

    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4})
    @DisplayName("random 값이 3 이하의 값이면 멈춘다")
    void carStop(int value) {
        //given
        Car car = new Car();
        MoveCar moveCar = new MoveCar();
        Race race = new Race();

        moveCar.check(value, car);

        // 정지 통과
        //then
        Assertions.assertThat(car.getCurrentLocation())
                .withFailMessage("입력값: %d, 예상 결과: %d, 실제 결과: %d", value, 0, car.getCurrentLocation())
                .isEqualTo(0);

    }

    @Test
    @DisplayName("random 값 범위 확인")
    void checkRandom() {
        MoveCar moveCar = new MoveCar();


        for (int i = 0; i < 100; i++) {
            int randomNum = moveCar.getRandNum();

            Assertions.assertThat(randomNum).isBetween(0, 9)
                    .withFailMessage("%d로 범위 벗어남", randomNum)
                    .isBetween(0, 9);
        }

        System.out.println("랜덤 범위 통과");
    }


    @ParameterizedTest
    @ValueSource(ints = {3, 4})
    @DisplayName("전진, 정지 메서드 확인")
    void checkRace(int value) {
        Car car = new Car();
        MoveCar moveCar = new MoveCar();

        moveCar.check(value, car);

        if (value == 3) {
            Assertions.assertThat(car.getCurrentLocation())
                    .withFailMessage("입력값: %d, 예상 결과: %d, 실제 결과: %d", value, 0, car.getCurrentLocation())
                    .isEqualTo(0);

            return;
        }

        Assertions.assertThat(car.getCurrentLocation())
                .withFailMessage("입력값: %d, 예상 결과: %d, 실제 결과: %d", value, 1, car.getCurrentLocation())
                .isEqualTo(1);

    }
}