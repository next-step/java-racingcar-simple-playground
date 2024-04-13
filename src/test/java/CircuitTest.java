import static org.assertj.core.api.Assertions.assertThatCode;

import generator.RandomNumberFakeGenerator;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

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
    @DisplayName("startRace와 findWinners 메소드는")
    class DescribeStartRaceAndFindWinners {

        @BeforeEach
        void setUp() {
            circuit.registerCars(List.of("name1", "name2", "name3", "name4"));
        }

        @Nested
        @DisplayName("만약 레이스를 진행시킬 횟수를 입력하면")
        class ContextWithInputRaceTryCount {

            @Test
            @DisplayName("레이스가 끝나고 우승자를 찾을 수 있습니다.")
            void afterRace_canFindWinner() {
                // given
                circuit.startRace(5);

                // when
                List<Car> winners = circuit.findWinners();

                // then
                Assertions.assertThat(winners).hasSize(4);
            }
        }
    }
}
