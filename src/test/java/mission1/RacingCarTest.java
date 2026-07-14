package mission1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("미션 1 : 레이싱카 테스트")
public class RacingCarTest {
    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    @DisplayName("숫자가 0~3 사이인 경우 정지")
    void test_랜덤숫자가0부터3사이값인경우(int value){
        final var car = new RacingCar("TestCar");
        car.moveAndStop(value);
        assertEquals(car.getDistance(), 0);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    @DisplayName("숫자가 4~9 사이인 경우 정지")
    void test_랜덤숫자가4부터9사이값인경우(int value){
        final var car = new RacingCar("TestCar");
        car.moveAndStop(value);
        assertEquals(car.getDistance(), 1, "4~9 사이의 값이 아니다.");
    }
}
