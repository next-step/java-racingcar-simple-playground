package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.MoveResults;
import racingcar.generator.RandomNumberFakeGenerator;

@DisplayName("서킷 테스트")
class CircuitTest {

    private Circuit circuit;

    @BeforeEach
    void setUp() {
        RandomNumberFakeGenerator generator = new RandomNumberFakeGenerator();
        circuit = new Circuit(generator);
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
                assertThatCode(() -> circuit.registerCars(carNames)).doesNotThrowAnyException();
            }
        }
    }

    @Nested
    @DisplayName("startRace 메소드는")
    class DescribeStartRace {

        @BeforeEach
        void setUp() {
            circuit.registerCars(List.of("name1", "name2", "name3", "name4"));
        }

        @Nested
        @DisplayName("만약 레이스를 진행시킬 횟수를 입력하면")
        class ContextWithInputRaceTryCount {

            @Test
            @DisplayName("레이스가 진행된 모든 결과를 반환합니다.")
            void eachRace_shouldReturnResults() {
                // given & when
                List<MoveResults> moveResults = circuit.startRace(5);
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
    }

    @Nested
    @DisplayName("findWinners 메소드는")
    class DescribeFindWinners {

        @BeforeEach
        void setUp() {
            circuit.registerCars(List.of("name1", "name2", "name3", "name4"));
            circuit.startRace(5);
        }

        @Nested
        @DisplayName("만약 모든 레이스가 종료된다면")
        class ContextWithEndOfTheRace {

            @Test
            @DisplayName("레이스의 우승자들을 조회할 수 있습니다.")
            void canFind_winnersOfRace() {
                // given & when
                List<String> winners = circuit.findWinners();

                // then
                assertThat(winners).containsExactly("name1", "name2", "name3", "name4");
            }
        }
    }
}
