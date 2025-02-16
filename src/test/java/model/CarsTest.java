package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

class CarsTest {

    private Cars cars;

    private static final int MOVE_ONE_TIME = 1;
    private static final int MOVE_TWO_TIMES = 2;
    private static final int MOVE_THREE_TIMES = 3;
    private static final int MOVE_FOUR_TIMES = 4;
    private static final int MOVE_FIVE_TIMES = 5;

    @BeforeEach
    void setUp() {
        cars = new Cars(List.of("car1", "car2", "car3"));
    }

    @Test
    @DisplayName("입력된 자동차 이름 리스트로 자동차들이 잘 생성되는지 검증한다")
    void testCarNamesFromInputList() {
        List<String> carNames = cars.getCars().stream()
                .map(Car::getCarName)
                .toList();

        assertThat(carNames).containsExactly("car1", "car2", "car3");
    }

    @Test
    @DisplayName("가장 높은 위치의 자동차들이 올바르게 우승자로 반환되는지 검증한다")
    void testReturnWinnersWithHighPosition() {
        cars.getCars().get(0).move(MOVE_FIVE_TIMES);
        cars.getCars().get(1).move(MOVE_THREE_TIMES);
        cars.getCars().get(2).move(MOVE_FIVE_TIMES);

        List<String> winnerNames = cars.getWinners().stream()
                .map(Car::getCarName)
                .toList();

        assertThat(winnerNames).containsExactlyInAnyOrder("car1", "car3");
    }

    @Test
    @DisplayName("가장 높은 위치의 자동차를 정확히 찾아내는지 검증한다.")
    void testFindMaxPositionCorrectly() {
        cars.getCars().get(0).move(MOVE_TWO_TIMES);
        cars.getCars().get(1).move(MOVE_FOUR_TIMES);
        cars.getCars().get(2).move(MOVE_ONE_TIME);

        int maxPosition = cars.getMaxPosition();

        assertThat(maxPosition).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차가 없을 경우 getMaxPosition 호출 시 예외가 발생하는지 검증한다")
    void testThrowExceptionWhenCarsAreEmpty() {
        Cars emptyCars = new Cars(List.of());

        assertThatThrownBy(emptyCars::getMaxPosition)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("경주에 참가한 자동차가 없습니다.");
    }
}
