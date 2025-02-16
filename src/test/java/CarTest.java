import domain.Car;
import domain.RacingGame;
import org.junit.jupiter.api.*;
import view.InputView;
import java.util.*;
import static org.assertj.core.api.Assertions.*;

class CarTest {
    private static final int MAX_BOUND = 10;
    private static final int FORWARD_STANDARD = 4;

    private static RacingGame racingGame;
    private static List<Car> cars;

    @BeforeAll
    static void setUp() {
        racingGame = new RacingGame();

        cars = new ArrayList<>(Arrays.asList(
                new Car("neo", 3),
                new Car("brie", 5),
                new Car("brown", 5)
        ));

        racingGame.getCars().clear();
        racingGame.getCars().addAll(cars);
    }

    @Nested
    @DisplayName("Car 클래스 테스트")
    class CarClassTest {

        @Test
        @DisplayName("자동차는 4 이상의 랜덤값이 나오면 전진한다.")
        void shouldMoveForward_WhenRandomValueIsMoreThanOrEqualTo4() {
            Car car = new Car("neo", 0);

            for (int i = FORWARD_STANDARD; i < MAX_BOUND; i++) {
                int initialPosition = car.getPosition();
                car.move();
                assertThat(car.getPosition()).isEqualTo(initialPosition + 1);
            }
        }

        @Test
        @DisplayName("자동차 이름이 정상적으로 생성된다.")
        void shouldCreateCar_WithValidName() {
            Car car = new Car("neo");
            assertThat(car.getCarName()).isEqualTo("neo");
        }
    }

    @Nested
    @DisplayName("RacingGame 클래스 테스트")
    class RacingGameClassTest {

        @Test
        @DisplayName("자동차 경주가 정상적으로 진행된다.")
        void shouldStartRace_Successfully() {
            racingGame.startRace();
            assertThat(racingGame.getWinnerCarNames()).isNotEmpty();
        }

        @Test
        @DisplayName("자동차들 중 MaxPosition 값을 찾는다.")
        void shouldReturnMaxPosition_OfCars() {
            int maxPosition = racingGame.getMaxPosition(cars);
            assertThat(maxPosition).isGreaterThanOrEqualTo(0);
        }

        @Test
        @DisplayName("최대 position을 가진 자동차를 우승자로 선정한다.")
        void shouldDetermineWinner_WithMaxPosition() {
            int maxPosition = racingGame.getMaxPosition(cars);
            assertThat(cars).allMatch(car -> car.getPosition() <= maxPosition);
        }

        @Test
        @DisplayName("자동차가 하나도 없을 경우 예외가 발생한다.")
        void shouldThrowException_WhenCarIsNotExist() {
            List<Car> emptyCars = List.of();
            assertThatThrownBy(() -> racingGame.getMaxPosition(emptyCars))
                    .isInstanceOf(NoSuchElementException.class);
        }
    }

    @Nested
    @DisplayName("InputView 클래스 테스트")
    class InputViewTest {

        @Test
        @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다.")
        void shouldThrowException_WhenCarNameExceeds5Characters() {
            System.setIn(new java.io.ByteArrayInputStream("abcdef,longname".getBytes()));

            assertThatThrownBy(InputView::getCarNames)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("자동차 이름은 5글자 이하로 작성해주세요.");
        }

        @Test
        @DisplayName("자동차 이름이 중복될 경우 중복이 제거된 리스트를 반환한다.")
        void shouldRemoveDuplicates_WhenCarNamesAreDuplicated() {
            System.setIn(new java.io.ByteArrayInputStream("neo,brie,neo,brown".getBytes()));

            List<String> expection = List.of("neo", "brie", "brown");
            List<String> actual = InputView.getCarNames();

            assertThat(actual).containsExactlyInAnyOrderElementsOf(expection);
        }

        @Test
        @DisplayName("자동차 이름 입력값이 비어있으면 예외가 발생한다.")
        void shouldThrowException_WhenCarNamesAreEmpty() {
            System.setIn(new java.io.ByteArrayInputStream("\n".getBytes()));

            assertThatThrownBy(InputView::getCarNames)
                    .isInstanceOf(NoSuchElementException.class)
                    .hasMessage("경주할 자동차 이름을 반드시 입력해주세요.");
        }

        @Test
        @DisplayName("올바른 자동차 이름이 입력되면 리스트를 반환한다.")
        void shouldReturnList_WhenValidCarNamesAreProvided() {
            System.setIn(new java.io.ByteArrayInputStream("neo, brie, brown".getBytes()));

            List<String> expection = List.of("neo", "brie", "brown");
            List<String> actual = InputView.getCarNames();

            assertThat(actual).containsExactlyInAnyOrderElementsOf(expection);
        }

        @Test
        @DisplayName("시도할 횟수가 숫자가 아니면 예외가 발생한다.")
        void shouldThrowException_WhenTryCountIsNotNumber() {
            System.setIn(new java.io.ByteArrayInputStream("string".getBytes()));

            assertThatThrownBy(InputView::getTryCount)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("올바른 숫자를 입력해주세요.");
        }

        @Test
        @DisplayName("시도할 횟수가 1 미만이면 예외가 발생한다.")
        void shouldThrowException_WhenTryCountIsLessThan1() {
            System.setIn(new java.io.ByteArrayInputStream("-3".getBytes()));

            assertThatThrownBy(InputView::getTryCount)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("시도할 회수는 1 이상의 정수여야 합니다.");
        }

        @Test
        @DisplayName("올바른 시도 횟수가 입력되면 반환한다.")
        void shouldReturnTryCount_WhenValidNumberIsProvided() {
            System.setIn(new java.io.ByteArrayInputStream("3".getBytes()));

            int expection = 3;
            int actual = InputView.getTryCount();

            assertThat(actual).isEqualTo(expection);
        }
    }
}
