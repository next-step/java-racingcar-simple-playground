package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

class CarsTest {

    private Cars cars;

    private static final int MOVABLE_NUMBER = 5; // 이동 가능
    private static final int UNMOVABLE_NUMBER = 3; // 이동 불가

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
        cars.getCars().get(0).move(MOVABLE_NUMBER);
        cars.getCars().get(1).move(UNMOVABLE_NUMBER);
        cars.getCars().get(2).move(MOVABLE_NUMBER);

        List<String> winnerNames = cars.getWinners().stream()
                .map(Car::getCarName)
                .toList();

        assertThat(winnerNames).containsExactlyInAnyOrder("car1", "car3");
    }

    @Test
    @DisplayName("가장 높은 위치의 자동차를 정확히 찾아내는지 검증한다.")
    void testFindMaxPositionCorrectly() {
        cars.getCars().get(0).move(UNMOVABLE_NUMBER);
        cars.getCars().get(1).move(MOVABLE_NUMBER);
        cars.getCars().get(2).move(UNMOVABLE_NUMBER);

        List<Car> winnerCar = cars.getWinners();

        assertThat(winnerCar.get(0)).isEqualTo(cars.getCars().get(1));
    }

    @Test
    @DisplayName("자동차가 없을 경우 getWinners 호출 시 예외가 발생하는지 검증한다")
    void testThrowExceptionWhenCarsAreEmpty() {
        Cars emptyCars = new Cars(List.of());

        assertThatThrownBy(emptyCars::getWinners)
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("경주에 참가한 자동차가 없습니다.");
    }
}
