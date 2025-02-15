package service;

import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static utils.RacingGameTestUtil.*;

class RacingGameServiceTest {

    private static final char COLON_DELIMITER = ':';
    private static final int LOWER_LIMIT_OF_FORWARD_CAPABLE = 4;
    private static final String BASIC_CAR_NAME = "hello";
    private static final String WHITE_SPACE = " ";

    private final RacingGameService racingGameService = new RacingGameService();

    @Nested
    class splitInputCarNames {

        @ParameterizedTest
        @CsvSource(
                value = {"1,2,3:3", "ab,cd,ef,gh:4", "김영한,이일민:2"},
                delimiter = COLON_DELIMITER
        )
        @DisplayName("쉼표로 구분된 문자열을 나눠 배열로 만든다")
        void convertStringIntoArray(String inputCarNames, int expectedSize) {
            String[] expectedArray = inputCarNames.split(",");
            String[] actualArray = racingGameService.splitInputCarNames(inputCarNames);
            int actualSize = actualArray.length;

            assertThat(actualSize).isEqualTo(expectedSize);
            assertThat(hasEqualElements(actualArray, expectedArray)).isTrue();
        }
    }

    @Nested
    class createCarsFromNames {

        @ParameterizedTest
        @DisplayName("문자열 배열을 통해 여러 Car 인스턴스를 생성하고 List<Car>로 반환한다")
        @CsvSource(
                value = {
                        "abc def ghi hello:4",
                        "hahah 12345 aaaaa:3",
                        "hello bye hi:3",
                        "a b c d e f g:7"
                },
                delimiter = COLON_DELIMITER
        )
        void getCarCollectionFromStringArray(String carNames, int expectedSize) {
            String[] carNameArray = carNames.split(WHITE_SPACE);
            List<Car> cars = racingGameService.createCarsFromNames(carNameArray);

            assertThat(cars.size()).isEqualTo(expectedSize);
        }
    }

    @Nested
    class validateGameCount {

        @ParameterizedTest
        @DisplayName("입력받은 시도 횟수가 적절한지 검증한다")
        @ValueSource(ints = {1, 2, 3, 10, 200, 3000, Integer.MAX_VALUE})
        void checkGameCount(int gameCount) {
            racingGameService.validateGameCount(gameCount);
        }

        @ParameterizedTest
        @DisplayName("최소치 이하의 시도 횟수를 넘기면 예외가 발생한다")
        @ValueSource(ints = {0, -1, -10, -200, -3000, Integer.MIN_VALUE})
        void ifGameCountLessThanMinimumThenThrowException(int illegalGameCount) {
            assertThatThrownBy(() -> racingGameService.validateGameCount(illegalGameCount))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

    @Nested
    class proceed {

        @ParameterizedTest
        @DisplayName("최소치 이상의 값을 넘기면 Car.goForward()를 호출해 moveDistance를 증가시킨다")
        @ValueSource(ints = {LOWER_LIMIT_OF_FORWARD_CAPABLE, 5, 10, 200, 300, Integer.MAX_VALUE})
        void ifNumberOverThanLowerLimitThenMakeCarGoForward(int goForwardDecider) {
            Car car = Car.from(BASIC_CAR_NAME);
            int prevMoveDistance = car.getMoveDistance();

            racingGameService.proceedCar(car, goForwardDecider);
            int nextMoveDistance = car.getMoveDistance();

            assertThat(prevMoveDistance).isNotEqualTo(nextMoveDistance);
        }

        @ParameterizedTest
        @DisplayName("최소치 미만의 값을 넘기면 아무 동작도 수행하지 않는다")
        @ValueSource(ints = {LOWER_LIMIT_OF_FORWARD_CAPABLE - 1, 0, -1, -20, -300, Integer.MIN_VALUE})
        void ifNumberLessThanMinimumThenNothingHappen(int goForwardDecider) {
            Car car = Car.from(BASIC_CAR_NAME);
            int prevMoveDistance = car.getMoveDistance();

            racingGameService.proceedCar(car, goForwardDecider);
            int nextMoveDistance = car.getMoveDistance();

            assertThat(prevMoveDistance).isEqualTo(nextMoveDistance);
        }

    }

    @Nested
    class getLongestMoveDistance {

        @ParameterizedTest
        @DisplayName("List<Car>를 통해 가장 긴 moveDistance를 구한다")
        @ValueSource(ints = {1, 20, 300, 4000, 50000, Integer.MAX_VALUE})
        void getLongestMoveDistance_Success(int longestMoveDistance) {
            List<Car> cars = getCarsWithLongestMoveDistance(longestMoveDistance);

            int actualResult = racingGameService.getLongestMoveDistance(cars);

            assertThat(actualResult).isEqualTo(longestMoveDistance);
        }

        @Test
        @DisplayName("빈 List를 전달할 경우 예외가 발생한다")
        void getLongestMoveDistance_EmptyListException() {
            List<Car> cars = List.of();

            assertThatThrownBy(() -> racingGameService.getLongestMoveDistance(cars))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

    @Nested
    class getWinners {

        @ParameterizedTest
        @DisplayName("인자로 넘긴 longestMoveDistance와 똑같은 moveDistance를 지닌 Car들을 List로 반환한다")
        @ValueSource(ints = {1, 10, 200, 300, Integer.MAX_VALUE})
        void getCarHasLongestMoveDistance(int longestMoveDistance) {
            List<Car> cars = getCarsWithLongestMoveDistance(longestMoveDistance);

            List<Car> winners = racingGameService.getWinners(cars, longestMoveDistance);

            for (Car winner : winners) {
                assertThat(winner.getMoveDistance()).isEqualTo(longestMoveDistance);
            }
        }

    }

}