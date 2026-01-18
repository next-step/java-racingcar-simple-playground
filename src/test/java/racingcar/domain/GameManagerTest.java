package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.GameManager;

class GameManagerTest {

    private GameManager gameManager;

    @BeforeEach
    void setUp() {
        gameManager = new GameManager();
    }

    @DisplayName("랜덤 값이 4 이상인 경우에는 전진한다.")
    @Test
    void moveWhenRandomValueIs4OrMore() {
        // given
        Car car = new Car("test");
        int randomValue = 4;

        // when
        gameManager.move(car, randomValue);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("랜덤 값이 3 이하일 경우에는 전진하지 않는다.")
    @Test
    void stopWhenRandomValueIs3OrLess() {
        // given
        Car car = new Car("test");
        int randomValue = 3;

        // when
        gameManager.move(car, randomValue);

        // then
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("가장 큰 Position을 가진 자동차를 우승자로 선정할 수 있다. - 우승자 한 명")
    @Test
    void getWinCars_OneWinner() {
        // given
        GameManager gameManager = new GameManager();
        Car winnerCar = createCarWithPosition("A", 3);
        Car car1 = createCarWithPosition("B", 2);
        Car car2 = createCarWithPosition("C", 1);

        // when
        List<Car> winCars = gameManager.getWinCars(List.of(winnerCar, car1, car2));

        // then
        assertThat(winCars).hasSize(1);
        assertThat(winCars)
                .extracting(Car::getName)
                .containsExactly(winnerCar.getName());
    }

    @DisplayName("가장 큰 Position을 가진 자동차를 우승자로 선정할 수 있다. - 우승자 한 명 이상")
    @Test
    void getWinCars_MoreThanOneWinners() {
        // given
        GameManager gameManager = new GameManager();
        Car winnerCar1 = createCarWithPosition("A", 3);
        Car car1 = createCarWithPosition("B", 2);
        Car winnerCar2 = createCarWithPosition("C", 3);

        // when
        List<Car> winCars = gameManager.getWinCars(List.of(winnerCar1, car1, winnerCar2));

        // then
        assertThat(winCars).hasSize(2);
        assertThat(winCars)
                .extracting(Car::getName)
                .containsExactlyInAnyOrder(winnerCar1.getName(), winnerCar2.getName());
    }

    private Car createCarWithPosition(String name, int position) {
        Car car = new Car(name);

        for (int i = 0; i < position; i++) {
            car.moveForward();
        }

        return car;
    }
}