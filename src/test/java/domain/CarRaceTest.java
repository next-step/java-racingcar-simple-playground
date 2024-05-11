package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.RandomValueGenerator;

class CarRaceTest {

    @Test
    @DisplayName("입력 값이 4 이상일 때, 입력한 횟수만큼 이동거리가 갱신되는지 확인한다.")
    void raceStartTestWithCorrectInput() {
        final List<Car> cars = List.of(
                new Car("포르쉐", () -> 7),
                new Car("페라리", () -> 5)

        );
        final CarRace carRace = new CarRace(cars);

        final int gameCount = 5;
        for (int i = 0; i < gameCount; i++) {
            carRace.raceOneLap();
        }
        assertThat(cars).extracting("distance")
                .containsExactlyElementsOf(Collections.nCopies(cars.size(), gameCount));
    }

    @Test
    @DisplayName("입력 값이 4 미만일 때, 이동거리가 갱신되지 않는지 확인한다.")
    void raceStartTestWithInCorrectInput() {
        final List<Car> cars = List.of(
                new Car("포르쉐", () -> 3),
                new Car("페라리", () -> 2)

        );
        final CarRace carRace = new CarRace(cars);

        final int gameCount = 5;
        for (int i = 0; i < gameCount; i++) {
            carRace.raceOneLap();
        }
        assertThat(cars).extracting("distance")
                .containsExactlyElementsOf(Collections.nCopies(cars.size(),0));
    }

    @ParameterizedTest
    @MethodSource("getCarsForTest")
    @DisplayName("최종 우승자를 정상적으로 반환하는지 확인한다.")
    void selectWinnersTest(List<Car> cars) {
        final CarRace carRace = new CarRace(cars);

        final String winnerName = "포르쉐";
        final int gameCount = 5;
        for (int i = 0; i < gameCount; i++) {
            carRace.raceOneLap();
        }
        List<String> winners = carRace.selectWinners();

        assertThat(winners).contains(winnerName);
    }

    private static Stream<Arguments> getCarsForTest() {
        return Stream.of(
                Arguments.arguments(
                        List.of(
                                new Car("포르쉐", () -> 7),
                                new Car("페라리", new RandomValueGenerator())
                        )
                ),
                Arguments.arguments(
                        List.of(
                                new Car("포르쉐", () -> 7),
                                new Car("페라리", new RandomValueGenerator()),
                                new Car("람보르기니", new RandomValueGenerator()),
                                new Car("애스턴마틴", new RandomValueGenerator()),
                                new Car("벤틀리", new RandomValueGenerator())
                        )
                )
        );
    }

}
