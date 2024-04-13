package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.generator.RandomNumberFakeGenerator;

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
                // given & when
                List<MoveResults> moveResults = racingCircuit.startRace(5);
                List<Integer> eachResultCarSize = moveResults.stream()
                        .map(MoveResults::results)
                        .map(List::size)
                        .toList();

                // then
                Assertions.assertAll(
                        () -> assertThat(moveResults).hasSize(5),
                        () -> assertThat(eachResultCarSize).containsExactly(4, 4, 4, 4, 4)

                );
            }
        }

        @Nested
        @DisplayName("만약 0회 이하의 값이 입력되면")
        class ContextWithInvalidRaceTryCount {

            @ParameterizedTest
            @ValueSource(ints = {0, -1})
            @DisplayName("레이스를 진행할 수 없기에 예외가 발생합니다.")
            void canNotStartRace_withInvalidRaceTryCount(int invalidRaceTryCount) {
                // expect
                assertThatThrownBy(() -> racingCircuit.startRace(invalidRaceTryCount))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("레이스는 1회 이상 진행되어야 합니다.");
            }
        }
    }

    @Nested
    @DisplayName("findWinners 메소드는")
    class DescribeFindWinners {

        @BeforeEach
        void setUp() {
            racingCircuit.registerCars(List.of("name1", "name2", "name3", "name4"));
            racingCircuit.startRace(5);
        }

        @Nested
        @DisplayName("만약 모든 레이스가 종료된다면")
        class ContextWithEndOfTheRace {

            @Test
            @DisplayName("레이스의 우승자들을 조회할 수 있습니다.")
            void canFind_winnersOfRace() {
                // given & when
                List<String> winners = racingCircuit.findWinners();

                // then
                assertThat(winners).containsExactly("name1", "name2", "name3", "name4");
            }
        }
    }
}
