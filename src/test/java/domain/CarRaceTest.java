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

class CarRaceTest {

    @ParameterizedTest
    @MethodSource("getCarsForTest")
    @DisplayName("입력 값이 4 이상일 때, 입력한 횟수만큼 이동거리가 갱신되는지 확인한다.")
    void raceStartTestWithCorrectInput(List<Car> cars) {
        CarRace carRace = new CarRace(cars);

        int gameCount = 5;
        carRace.raceStart(gameCount, () -> 7);
        assertThat(cars).extracting("distance")
                .containsExactlyElementsOf(Collections.nCopies(cars.size(), gameCount));
    }

    @ParameterizedTest
    @MethodSource("getCarsForTest")
    @DisplayName("입력 값이 4 미만일 때, 이동거리가 갱신되지 않는지 확인한다.")
    void raceStartTestWithInCorrectInput(List<Car> cars) {
        CarRace carRace = new CarRace(cars);

        int gameCount = 5;
        carRace.raceStart(gameCount, () -> 2);
        assertThat(cars).extracting("distance")
                .containsExactlyElementsOf(Collections.nCopies(cars.size(),0));
    }

    private static Stream<Arguments> getCarsForTest() {
        return Stream.of(
                Arguments.arguments(
                        List.of(
                                new Car("포르쉐"),
                                new Car("페라리")
                        )
                ),
                Arguments.arguments(
                        List.of(
                                new Car("포르쉐"),
                                new Car("페라리"),
                                new Car("람보르기니"),
                                new Car("애스턴마틴"),
                                new Car("벤틀리")
                        )
                )
        );
    }

}
