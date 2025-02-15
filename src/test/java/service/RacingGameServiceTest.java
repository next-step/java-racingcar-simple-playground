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
                value = {"1,2,3:3", "ab,cd,ef,gh:4", "�迵��,���Ϲ�:2"},
                delimiter = COLON_DELIMITER
        )
        @DisplayName("��ǥ�� ���е� ���ڿ��� ���� �迭�� �����")
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
        @DisplayName("���ڿ� �迭�� ���� ���� Car �ν��Ͻ��� �����ϰ� List<Car>�� ��ȯ�Ѵ�")
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
        @DisplayName("�Է¹��� �õ� Ƚ���� �������� �����Ѵ�")
        @ValueSource(ints = {1, 2, 3, 10, 200, 3000, Integer.MAX_VALUE})
        void checkGameCount(int gameCount) {
            racingGameService.validateGameCount(gameCount);
        }

        @ParameterizedTest
        @DisplayName("�ּ�ġ ������ �õ� Ƚ���� �ѱ�� ���ܰ� �߻��Ѵ�")
        @ValueSource(ints = {0, -1, -10, -200, -3000, Integer.MIN_VALUE})
        void ifGameCountLessThanMinimumThenThrowException(int illegalGameCount) {
            assertThatThrownBy(() -> racingGameService.validateGameCount(illegalGameCount))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

    @Nested
    class proceed {

        @ParameterizedTest
        @DisplayName("�ּ�ġ �̻��� ���� �ѱ�� Car.goForward()�� ȣ���� moveDistance�� ������Ų��")
        @ValueSource(ints = {LOWER_LIMIT_OF_FORWARD_CAPABLE, 5, 10, 200, 300, Integer.MAX_VALUE})
        void ifNumberOverThanLowerLimitThenMakeCarGoForward(int goForwardDecider) {
            Car car = Car.from(BASIC_CAR_NAME);
            int prevMoveDistance = car.getMoveDistance();

            racingGameService.proceedCar(car, goForwardDecider);
            int nextMoveDistance = car.getMoveDistance();

            assertThat(prevMoveDistance).isNotEqualTo(nextMoveDistance);
        }

        @ParameterizedTest
        @DisplayName("�ּ�ġ �̸��� ���� �ѱ�� �ƹ� ���۵� �������� �ʴ´�")
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
        @DisplayName("List<Car>�� ���� ���� �� moveDistance�� ���Ѵ�")
        @ValueSource(ints = {1, 20, 300, 4000, 50000, Integer.MAX_VALUE})
        void getLongestMoveDistance_Success(int longestMoveDistance) {
            List<Car> cars = getCarsWithLongestMoveDistance(longestMoveDistance);

            int actualResult = racingGameService.getLongestMoveDistance(cars);

            assertThat(actualResult).isEqualTo(longestMoveDistance);
        }

        @Test
        @DisplayName("�� List�� ������ ��� ���ܰ� �߻��Ѵ�")
        void getLongestMoveDistance_EmptyListException() {
            List<Car> cars = List.of();

            assertThatThrownBy(() -> racingGameService.getLongestMoveDistance(cars))
                    .isInstanceOf(IllegalArgumentException.class);
        }

    }

    @Nested
    class getWinners {

        @ParameterizedTest
        @DisplayName("���ڷ� �ѱ� longestMoveDistance�� �Ȱ��� moveDistance�� ���� Car���� List�� ��ȯ�Ѵ�")
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