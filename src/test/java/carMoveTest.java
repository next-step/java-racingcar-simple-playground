import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.stream.IntStream;

public class carMoveTest {
    private static IntStream provideRandomNumbers() {
        Random random = new Random();
        return random.ints(10, 0, 10); // 10개의 0부터 9까지의 랜덤 숫자를 생성합니다.
    }

//    @ParameterizedTest
//    @ValueSource(ints={4,9})
//    @MethodSource("provideRandomNumbers")
    @Test
    @DisplayName("random 값이 4 이상일 경우 전진")
    void carMoveForward(){
        //given
        Car car = new Car();
        int location = car.getCurrent_location();

        int randomNum = car.getRandNum();

        System.out.println(randomNum);
        // when
        //1 추가
        int current_location=car.check(randomNum,car);

        //then
        Assertions.assertThat(current_location).isEqualTo(location + 1);

    }

    @Test
    @DisplayName("random 값이 3 이하의 값이면 멈춘다")
    void carStop(){
        //given
        Car car = new Car();
        int location = car.getCurrent_location();

        int randomNum = car.getRandNum();

        //when
        int current_location=car.check(randomNum,car);

        //then
        Assertions.assertThat(current_location).isEqualTo(location);

    }

    void checkWinner() {
        Car car = new Car();

    }
}
