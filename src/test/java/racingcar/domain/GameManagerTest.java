package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InputErrorCode;
import racingcar.exception.InvalidInputException;

class GameManagerTest {

    private final GameManager gameManager = new GameManager();


    @DisplayName("자동차 이름 리스트로 자동차를 생성하고 보관한다.")
    @Test
    void createsCarsFromNames() {
        // given
        List<String> names = List.of("A", "B", "C");

        // when
        gameManager.createCars(names);

        // then
        assertThat(gameManager.getCars()).hasSize(3);
        assertThat(gameManager.getCars())
                .extracting(Car::getName)
                .containsExactly("A", "B", "C");
    }

    @DisplayName("자동차 이름 리스트가 Null 이거나 비어있으면 예외를 발생시킨다.")
    @Test
    void createCars_throws_whenNamesEmpty() {
        assertThatThrownBy(() -> gameManager.createCars(List.of()))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage(InputErrorCode.CAR_NAMES_BAD_FORMAT.message());
    }

    @DisplayName("자동차 이름 리스트가 null이면 예외를 발생시킨다.")
    @Test
    void createCars_throws_whenNamesNull() {
        assertThatThrownBy(() -> gameManager.createCars(null))
                .isInstanceOf(InvalidInputException.class)
                .hasMessage(InputErrorCode.CAR_NAMES_BAD_FORMAT.message());
    }

    @DisplayName("랜덤 값이 4 이상인 경우에는 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveWhenRandomValueIs4OrMore(int randomValue) {
        // given
        Car car = new Car("test");

        // when
        gameManager.move(car, randomValue);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("랜덤 값이 3 이하일 경우에는 전진하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stopWhenRandomValueIs3OrLess(int randomValue) {
        // given
        Car car = new Car("test");

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