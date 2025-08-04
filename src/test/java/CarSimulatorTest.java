import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CarSimulatorTest {

    @Nested
    @DisplayName("CarSimulator 생성자 테스트")
    class ConstructorTest {

        @Test
        @DisplayName("정상적인 자동차 이름 목록과 라운드 수로 시뮬레이터가 생성된다")
        void 자동차_시뮬레이터_생성_성공() {
            // Given
            List<String> carNames = Arrays.asList("자동차1", "자동차2", "자동차3");
            int numberOfRounds = 5;

            // When
            CarSimulator carSimulator = new CarSimulator(carNames, numberOfRounds);

            // Then
            assertThat(carSimulator).isNotNull();
            assertThat(carSimulator.getCars()).hasSize(3);
            assertThat(carSimulator.getNumberOfRounds()).isEqualTo(5);
        }

    }

    @Nested
    @DisplayName("우승자 결정 테스트")
    class GetWinnersTest {

        @Test
        @DisplayName("시뮬레이션 전에도 우승자가 반환된다")
        void 우승자는_비어있지않음() {
            // Given
            List<String> carNames = Arrays.asList("우승자", "패배자");
            CarSimulator carSimulator = new CarSimulator(carNames, 0);

            // When
            String winners = carSimulator.getWinners();

            // Then
            assertThat(winners).isNotNull();
            assertThat(winners).isNotEmpty();
        }

        @Test
        @DisplayName("자동차가 하나일 때 그 자동차가 우승자가 된다")
        void 단일_자동차_우승자() {
            // Given
            List<String> carNames = Arrays.asList("혼자자동차");
            CarSimulator carSimulator = new CarSimulator(carNames, 0);

            // When
            String winners = carSimulator.getWinners();

            // Then
            assertThat(winners).isEqualTo("혼자자동차");
        }

        @Test
        @DisplayName("여러 자동차가 동점일 때 모두 우승자가 된다")
        void 동점_우승자_여러명() {
            // Given
            List<String> carNames = Arrays.asList("자동차1", "자동차2", "자동차3");
            CarSimulator carSimulator = new CarSimulator(carNames, 0); // 라운드 0으로 모두 위치 0

            // When
            String winners = carSimulator.getWinners();

            // Then
            assertThat(winners).contains("자동차1");
            assertThat(winners).contains("자동차2");
            assertThat(winners).contains("자동차3");
            assertThat(winners.split(",")).hasSize(3);
        }

        @Test
        @DisplayName("자동차가 없을 때 예외가 발생한다")
        void 자동차_없을때_예외_발생() {
            // Given
            List<String> carNames = Collections.emptyList();
            CarSimulator carSimulator = new CarSimulator(carNames, 0);

            // When & Then
            assertThatThrownBy(() -> carSimulator.getWinners())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("자동차가 없습니다.");
        }

        @Test
        @DisplayName("시뮬레이션 후 가장 멀리 간 자동차가 우승자가 된다")
        void 시뮬레이션_후_최고_위치_자동차_우승() {
            // Given
            List<String> carNames = Arrays.asList("자동차1", "자동차2", "자동차3");
            CarSimulator carSimulator = new CarSimulator(carNames, 10);

            // When
            carSimulator.simulate();
            String winners = carSimulator.getWinners();

            // Then
            assertThat(winners).isNotNull();
            assertThat(winners).isNotEmpty();

            // 우승자들이 실제로 최고 위치에 있는지 확인
            int maxPosition = carSimulator.getCars().stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

            String[] winnerNames = winners.split(",");
            for (String winnerName : winnerNames) {
                Car winner = carSimulator.getCars().stream()
                    .filter(car -> car.getName().equals(winnerName.trim()))
                    .findFirst()
                    .orElseThrow();
                assertThat(winner.getPosition()).isEqualTo(maxPosition);
            }
        }
    }

    @Nested
    @DisplayName("자동차 목록 관리 테스트")
    class CarManagementTest {

        @Test
        @DisplayName("자동차 이름이 올바르게 설정된다")
        void 자동차_이름_올바른_설정() {
            // Given
            List<String> carNames = Arrays.asList("포르쉐", "페라리", "람보르기니");
            CarSimulator carSimulator = new CarSimulator(carNames, 1);

            // When
            List<Car> cars = carSimulator.getCars();

            // Then
            assertThat(cars.get(0).getName()).isEqualTo("포르쉐");
            assertThat(cars.get(1).getName()).isEqualTo("페라리");
            assertThat(cars.get(2).getName()).isEqualTo("람보르기니");
        }

        @Test
        @DisplayName("모든 자동차의 초기 위치는 0이다")
        void 자동차_초기_위치_0() {
            // Given
            List<String> carNames = Arrays.asList("자동차1", "자동차2", "자동차3");
            CarSimulator carSimulator = new CarSimulator(carNames, 0);

            // When
            List<Car> cars = carSimulator.getCars();

            // Then
            for (Car car : cars) {
                assertThat(car.getPosition()).isEqualTo(0);
            }
        }
    }

}
