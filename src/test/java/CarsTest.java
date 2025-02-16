import domain.Car;
import domain.Cars;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.NoSuchElementException;
import static org.assertj.core.api.Assertions.*;

class CarsTest {

    private Cars cars;
    private static final List<String> CAR_NAMES = List.of("neo", "brie", "brown");

    @BeforeEach
    void setUp() {
        cars = new Cars(CAR_NAMES);
    }

    @Nested
    @DisplayName("Cars 객체 생성")
    class CreateCarsTest {

        @Test
        @DisplayName("Cars 객체를 생성하면 입력된 이름의 Car 객체가 포함 되어야 한다.")
        void shouldMakeCarsObject_WithNames() {
            List<Car> carList = cars.getCars();

            assertThat(carList).hasSize(CAR_NAMES.size());
            assertThat(carList)
                    .extracting(Car::getCarName)
                    .containsExactlyElementsOf(CAR_NAMES);
        }

        @Test
        @DisplayName("getCars()는 리스트를 반환해야 한다.")
        void shouldReturnList_WhenGetCarsCalled() {
            List<Car> carList = cars.getCars();

            assertThatThrownBy(() -> carList.add(new Car("String")))
                    .isInstanceOf(UnsupportedOperationException.class);
        }
    }

    @Nested
    @DisplayName("우승자 명단 확인")
    class DetermineWinnersTest {

        @Test
        @DisplayName("우승한 자동차들은 전부 Cars에 포함되어있다.")
        void shouldReturnCarWithMaxPosition_AsWinner() {
            cars.moveCars(() -> true);
            List<String> winnerCarNames = cars.getWinnerCarNames();

            assertThat(winnerCarNames)
                    .isNotEmpty()
                    .allMatch(CAR_NAMES::contains);
        }

        @Test
        @DisplayName("우승한 자동차가 하나도 없을 경우 예외가 발생한다.")
        void shouldThrowException_WhenCarsNoExist() {
            Cars emptyCars = new Cars(List.of());

            assertThatThrownBy(emptyCars::getWinnerCarNames)
                    .isInstanceOf(NoSuchElementException.class);
        }
    }

}
