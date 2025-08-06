import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import strategy.FixedMoveStrategy;

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

        @Nested
        @DisplayName("전략 패턴 테스트")
        class MoveStrategyTest {

            @Test
            @DisplayName("항상 이동하는 전략으로 모든 자동차가 이동한다")
            void 항상_이동_전략_테스트() {
                // Given
                List<String> carNames = Arrays.asList("자동차1", "자동차2", "자동차3");
                CarSimulator carSimulator = new CarSimulator(carNames, 1);
                carSimulator.setMoveStrategy(new FixedMoveStrategy(true));

                // When
                carSimulator.moveCars();

                // Then
                for (Car car : carSimulator.getCars()) {
                    assertThat(car.getPosition()).isEqualTo(1);
                }
            }

            @Test
            @DisplayName("절대 이동하지 않는 전략으로 모든 자동차가 정지한다")
            void 절대_이동하지_않는_전략_테스트() {
                // Given
                List<String> carNames = Arrays.asList("자동차1", "자동차2", "자동차3");
                CarSimulator carSimulator = new CarSimulator(carNames, 1);
                carSimulator.setMoveStrategy(new FixedMoveStrategy(false));

                // When
                carSimulator.moveCars();

                // Then
                for (Car car : carSimulator.getCars()) {
                    assertThat(car.getPosition()).isEqualTo(0);
                }
            }
        }

        @Nested
        @DisplayName("시뮬레이션 테스트")
        class SimulationTest {

            @Test
            @DisplayName("지정된 라운드만큼 시뮬레이션이 실행된다")
            void 라운드_수만큼_시뮬레이션_실행() {
                // Given
                List<String> carNames = Arrays.asList("자동차1", "자동차2");
                int numberOfRounds = 3;
                CarSimulator carSimulator = new CarSimulator(carNames, numberOfRounds);
                carSimulator.setMoveStrategy(new FixedMoveStrategy(true));

                // When
                carSimulator.simulate();

                // Then
                for (Car car : carSimulator.getCars()) {
                    assertThat(car.getPosition()).isEqualTo(numberOfRounds);
                }
            }
        }

        @Nested
        @DisplayName("우승자 결정 테스트")
        class GetWinnersTest {

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
            @DisplayName("특정 자동차만 이동했을 때 그 자동차가 우승자가 된다")
            void 특정_자동차만_이동_우승() {
                // Given
                List<String> carNames = Arrays.asList("우승자", "패배자1", "패배자2");
                CarSimulator carSimulator = new CarSimulator(carNames, 1);

                // 첫 번째 자동차만 이동하도록 설정
                carSimulator.getCars().get(0).move(new FixedMoveStrategy(true));

                // When
                String winners = carSimulator.getWinners();

                // Then
                assertThat(winners).isEqualTo("우승자");
            }

            @Test
            @DisplayName("동일한 최고 위치의 자동차들이 모두 우승자가 된다")
            void 동일_최고_위치_우승자들() {
                // Given
                List<String> carNames = Arrays.asList("우승자1", "우승자2", "패배자");
                CarSimulator carSimulator = new CarSimulator(carNames, 1);

                // 처음 두 자동차만 이동
                carSimulator.getCars().get(0).move(new FixedMoveStrategy(true));
                carSimulator.getCars().get(1).move(new FixedMoveStrategy(true));

                // When
                String winners = carSimulator.getWinners();

                // Then
                assertThat(winners).contains("우승자1");
                assertThat(winners).contains("우승자2");
                assertThat(winners).doesNotContain("패배자");
                assertThat(winners.split(",")).hasSize(2);
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

            @Test
            @DisplayName("자동차 이름의 공백이 제거된다")
            void 자동차_이름_공백_제거() {
                // Given
                List<String> carNames = Arrays.asList(" 자동차1 ", "  자동차2  ", "자동차3");
                CarSimulator carSimulator = new CarSimulator(carNames, 1);

                // When
                List<Car> cars = carSimulator.getCars();

                // Then
                assertThat(cars.get(0).getName()).isEqualTo("자동차1");
                assertThat(cars.get(1).getName()).isEqualTo("자동차2");
                assertThat(cars.get(2).getName()).isEqualTo("자동차3");
            }

            @Test
            @DisplayName("getCars 메서드는 원본 리스트의 복사본을 반환한다")
            void getCars_복사본_반환() {
                // Given
                List<String> carNames = Arrays.asList("자동차1", "자동차2");
                CarSimulator carSimulator = new CarSimulator(carNames, 1);

                // When
                List<Car> cars1 = carSimulator.getCars();
                List<Car> cars2 = carSimulator.getCars();

                // Then
                assertThat(cars1).isNotSameAs(cars2);
                assertThat(cars1).isEqualTo(cars2);
            }
        }
    }
}
