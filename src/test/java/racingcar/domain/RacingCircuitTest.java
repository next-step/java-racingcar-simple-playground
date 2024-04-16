package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.infrastructure.RandomNumberFakeGenerator;

@DisplayName("서킷 테스트")
class RacingCircuitTest {

    private RacingCircuit racingCircuit;

    @BeforeEach
    void setUp() {
        RandomNumberFakeGenerator generator = new RandomNumberFakeGenerator();
        racingCircuit = new RacingCircuit(generator);
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
                List<String> carNames = List.of("name1", "name2", "name3", "name4");

                // expect
                assertThatCode(() -> racingCircuit.registerCars(carNames)).doesNotThrowAnyException();
            }
        }
    }

    @Nested
    @DisplayName("startRace 메소드는")
    class DescribeStartRace {

        @BeforeEach
        void setUp() {
            racingCircuit.registerCars(List.of("name1", "name2", "name3", "name4"));
        }

        @Nested
        @DisplayName("만약 레이스를 진행시킬 횟수를 입력하면")
        class ContextWithInputRaceTryCount {

            @Test
            @DisplayName("레이스가 진행된 모든 결과를 반환합니다.")
            void eachRace_shouldReturnResults() {
                // when
                List<Cars> carsSet = racingCircuit.startRace(5);
                List<Integer> eachResultCarSize = carsSet.stream()
                        .map(Cars::cars)
                        .map(List::size)
                        .toList();

                // then
                assertAll(
                        () -> assertThat(carsSet).hasSize(5),
                        () -> assertThat(eachResultCarSize).containsExactly(4, 4, 4, 4, 4)
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
                racingCircuit.registerCars(List.of("name1", "name2", "name3", "name4"));
                racingCircuit.startRace(5);
            }

            @Test
            @DisplayName("레이스의 우승자들을 조회할 수 있습니다.")
            void canFind_winnersOfRace() {
                // when
                Cars winners = racingCircuit.findWinners();
                List<String> winnerNames = winners.cars()
                        .stream()
                        .map(Car::getName)
                        .toList();

                // then
                assertThat(winnerNames).containsExactly("name1", "name2", "name3", "name4");
            }
        }

        @Nested
        @DisplayName("만약 아무런 차량도 등록되지 않았다면")
        class ContextWithEmptyCars {

            @BeforeEach
            void setUp() {
                racingCircuit.registerCars(Collections.emptyList());
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
