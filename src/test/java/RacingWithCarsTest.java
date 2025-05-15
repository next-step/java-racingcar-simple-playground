import data.CarSnapShot;
import data.RoundResult;
import domain.Car;
import domain.RacingWithCars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import utils.MovableNumberGenerator;
import utils.RandomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingWithCarsTest {

    @DisplayName("Race 객체 생성시 입력된 Times가 1 미만이면 InvalidTimesException 예외를 던진다.")
    @ParameterizedTest(name = "if (times == {0}) => throws InvalidTimesException")
    @ValueSource(ints = {0, -1})
    void validateTimesTest(int times) {

        String[] carNames = {"car1", "car2"};

        assertThatThrownBy(() -> new RacingWithCars(carNames, times, new RandomNumberGenerator()))
                .isInstanceOf(RacingWithCars.InvalidTimesException.class)
                .hasMessage("게임 진행 횟수는 1 이상을 입력해주세요.");
    }

    @Test
    @DisplayName("자동차가 옳바르게 생성되는지 테스트")
    void testCarInitialization() {

        String[] carNames = {"car1", "car2", "car3"};
        RacingWithCars racing = new RacingWithCars(carNames, 5, new RandomNumberGenerator());
        List<Car> cars = racing.getParticipatingCars();

        assertThat(cars).hasSize(3)
                .extracting(Car::getName)
                .containsExactlyInAnyOrder("car1", "car2", "car3");
    }

    @Test
    @DisplayName("하나의 라운드가 끝나면, 참여한 모든 자동차에 대한 결과를 제공한다.")
    void testRaceHistoryContainsAllCarRecord() {

        String[] carNames = {"car1", "car2"};
        RacingWithCars racing = new RacingWithCars(carNames, 5, new RandomNumberGenerator());

        for (int i = 0; i < racing.getTimes(); i++) {
            RoundResult roundResult = racing.raceOneRound();
            assertThat(roundResult.getCarSnapShots()).hasSize(2);
        }
    }

    @ParameterizedTest(name = "주행거리:{0}, 예상 우승자 인덱스 : {1}")
    @MethodSource("carDistancesForWinners")
    void testGetWinnerCorrectly(int[] distances, List<Integer> expectedWinnerIndexes) {

        String[] carNames = {"car1", "car2", "car3"};
        RacingWithCars racing = new RacingWithCars(carNames, 1, new RandomNumberGenerator());
        List<Car> participaingCars = racing.getParticipatingCars();

        for (int i = 0; i < 3; i++) {
            Car car = participaingCars.get(i);
            forceToMoveForWantingTimes(distances[i], car);
        }

        List<CarSnapShot> winners = racing.getWinner();

        List<CarSnapShot> expectedWinners = expectedWinnerIndexes.stream()
                .map(index -> new CarSnapShot(carNames[index], distances[index]))
                .collect(Collectors.toList());

        assertThat(winners)
                .containsExactlyInAnyOrderElementsOf(expectedWinners);
    }

    void forceToMoveForWantingTimes(int times, Car car) {
        for (int i = 0; i < times; i++) {
            car.move(new MovableNumberGenerator());
        }
    }

    private static Stream<Arguments> carDistancesForWinners() {
        return Stream.of(
                Arguments.of(new int[]{5, 2, 4}, List.of(0)),
                Arguments.of(new int[]{1, 3, 3}, List.of(1, 2)),
                Arguments.of(new int[]{0, 0, 0}, List.of(0, 1, 2))
        );
    }
}
