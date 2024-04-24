package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.infrastructure.FakeMovableNumberGenerator;
import racingcar.infrastructure.FakeNotMovableNumberGenerator;

@DisplayName("서킷 테스트")
class RacingCircuitTest {

    private NumberGenerator fakeMovableNumberGenerator;
    private NumberGenerator fakeNotMovableNumberGenerator;

    @BeforeEach
    void setUp() {
        fakeMovableNumberGenerator = new FakeMovableNumberGenerator();
        fakeNotMovableNumberGenerator = new FakeNotMovableNumberGenerator();
    }

    @Nested
    @DisplayName("RacingCircuit 생성자는")
    class DescribeRegisterCars {

        @Nested
        @DisplayName("만약 등록할 자동차의 이름과 레이싱 시도 횟수를 입력하면")
        class ContextWithCarNames {

            @Test
            @DisplayName("경주용 차량들을 생성하고 등록시킵니다.")
            void registerCarsForRacing() {
                // given
                Cars cars = Cars.createCarsWithGenerator(
                        List.of("name1", "name2", "name3", "name4"),
                        fakeMovableNumberGenerator
                );

                // expect
                assertThatCode(() -> new RacingCircuit(cars, 5)).doesNotThrowAnyException();
            }
        }

        @Nested
        @DisplayName("만약 레이싱 시도 횟수에 0회 이하의 값이 입력되면")
        class ContextWithInvalidRaceTryCount {

            @Test
            @DisplayName("레이스를 진행할 수 없기에 예외가 발생합니다.")
            void canNotStartRace_withInvalidRaceTryCount() {
                // given
                Cars cars = Cars.createCarsWithGenerator(
                        List.of("name1", "name2", "name3", "name4"),
                        fakeMovableNumberGenerator
                );

                // expect
                assertThatThrownBy(() -> new RacingCircuit(cars, 0))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("레이스는 1회 이상 진행되어야 합니다.");
            }
        }
    }

    @Nested
    @DisplayName("startRace 메소드는")
    class DescribeStartRace {

        @Nested
        @DisplayName("만약 레이스를 진행하면")
        class ContextWithInputRaceTryCount {

            @Test
            @DisplayName("레이스가 진행된 모든 결과를 반환합니다.")
            void eachRace_shouldReturnResults() {
                // given
                Cars cars = Cars.createCarsWithGenerator(
                        List.of("name1", "name2", "name3", "name4"),
                        fakeMovableNumberGenerator
                );
                RacingCircuit circuit = new RacingCircuit(cars, 5);

                // when
                Map<Integer, Cars> roundRecords = circuit.startRace();

                // then
                assertAll(
                        () -> assertThat(roundRecords.keySet()).hasSize(5),
                        () -> assertThat(roundRecords.values()).hasSize(5)
                );
            }
        }
    }

    @Nested
    @DisplayName("findWinners 메소드는")
    class DescribeFindWinners {

        @Nested
        @DisplayName("만약 모든 레이스가 종료된다면")
        class ContextWithEndOfTheRace {

            @BeforeEach
            void setUp() {
            }

            @Test
            @DisplayName("레이스의 우승자들을 조회할 수 있습니다.")
            void canFind_winnersOfRace() {
                // given
                Cars cars = new Cars(List.of(
                        new Car("name1", 0, fakeMovableNumberGenerator),
                        new Car("name2", 0, fakeMovableNumberGenerator),
                        new Car("name3", 0, fakeNotMovableNumberGenerator),
                        new Car("name4", 0, fakeNotMovableNumberGenerator)
                ));
                RacingCircuit circuit = new RacingCircuit(cars, 5);
                circuit.startRace();

                // when
                Cars winners = circuit.findWinners();

                // then
                assertThat(winners.cars())
                        .extracting(Car::getName)
                        .containsExactly("name1", "name2");
            }
        }

        @Nested
        @DisplayName("만약 아무런 차량도 등록되지 않았다면")
        class ContextWithEmptyCars {

            @Test
            @DisplayName("우승자를 찾을 수 없다는 예외를 발생시킵니다.")
            void canFind_winnersOfRace() {
                // given
                RacingCircuit circuit = new RacingCircuit(new Cars(Collections.emptyList()), 5);
                circuit.startRace();

                // expect
                assertThatThrownBy(circuit::findWinners)
                        .isInstanceOf(IllegalStateException.class)
                        .hasMessage("우승자를 찾을 수 없습니다.");
            }
        }
    }
}
