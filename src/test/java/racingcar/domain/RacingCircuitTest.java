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

    private RacingCircuit racingCircuit;
    private NumberGenerator fakeMovableNumberGenerator;
    private NumberGenerator fakeNotMovableNumberGenerator;

    @BeforeEach
    void setUp() {
        racingCircuit = new RacingCircuit();
        fakeMovableNumberGenerator = new FakeMovableNumberGenerator();
        fakeNotMovableNumberGenerator = new FakeNotMovableNumberGenerator();
    }

    @Nested
    @DisplayName("registerCars 메소드는")
    class DescribeRegisterCars {

        @Nested
        @DisplayName("만약 등록할 자동차의 이름들을 입력하면")
        class ContextWithCarNames {

            @Test
            @DisplayName("경주용 차량들을 생성하고 등록시킵니다.")
            void registerCarsForRacing() {
                // given
                Cars cars = Cars.createCarsWithGenerator(List.of("name1", "name2", "name3", "name4"),
                        fakeMovableNumberGenerator);

                // expect
                assertThatCode(() -> racingCircuit.registerCars(cars)).doesNotThrowAnyException();
            }
        }
    }

    @Nested
    @DisplayName("startRace 메소드는")
    class DescribeStartRace {

        @BeforeEach
        void setUp() {
            Cars cars = Cars.createCarsWithGenerator(List.of("name1", "name2", "name3", "name4"),
                    fakeMovableNumberGenerator);
            racingCircuit.registerCars(cars);
        }

        @Nested
        @DisplayName("만약 레이스를 진행시킬 횟수를 입력하면")
        class ContextWithInputRaceTryCount {

            @Test
            @DisplayName("레이스가 진행된 모든 결과를 반환합니다.")
            void eachRace_shouldReturnResults() {
                // when
                Map<Integer, Cars> roundRecords = racingCircuit.startRace(5);

                // then
                assertAll(
                        () -> assertThat(roundRecords.keySet()).hasSize(5),
                        () -> assertThat(roundRecords.values()).hasSize(5)
                );
            }
        }

        @Nested
        @DisplayName("만약 0회 이하의 값이 입력되면")
        class ContextWithInvalidRaceTryCount {

            @Test
            @DisplayName("레이스를 진행할 수 없기에 예외가 발생합니다.")
            void canNotStartRace_withInvalidRaceTryCount() {
                // expect
                assertThatThrownBy(() -> racingCircuit.startRace(0))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("레이스는 1회 이상 진행되어야 합니다.");
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
                Cars cars = new Cars(List.of(
                        new Car("name1", 0, fakeMovableNumberGenerator),
                        new Car("name2", 0, fakeMovableNumberGenerator),
                        new Car("name3", 0, fakeNotMovableNumberGenerator),
                        new Car("name4", 0, fakeNotMovableNumberGenerator)
                ));

                racingCircuit.registerCars(cars);
                racingCircuit.startRace(5);
            }

            @Test
            @DisplayName("레이스의 우승자들을 조회할 수 있습니다.")
            void canFind_winnersOfRace() {
                // when
                Cars winners = racingCircuit.findWinners();

                // then
                assertThat(winners.cars())
                        .extracting(Car::getName)
                        .containsExactly("name1", "name2");
            }
        }

        @Nested
        @DisplayName("만약 아무런 차량도 등록되지 않았다면")
        class ContextWithEmptyCars {

            @BeforeEach
            void setUp() {
                racingCircuit.registerCars(new Cars(Collections.emptyList()));
                racingCircuit.startRace(5);
            }

            @Test
            @DisplayName("우승자를 찾을 수 없다는 예외를 발생시킵니다.")
            void canFind_winnersOfRace() {
                // expect
                assertThatThrownBy(() -> racingCircuit.findWinners())
                        .isInstanceOf(IllegalStateException.class)
                        .hasMessage("우승자를 찾을 수 없습니다.");
            }
        }
    }
}
