package car;

import static org.assertj.core.api.Assertions.assertThat;

import car.domain.model.Judge;
import car.domain.model.MovingCar;
import car.domain.model.Name;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class JudgeTest {

    private Judge judge;

    @BeforeEach
    void setUp() {
        judge = new Judge();
    }

    @DisplayName("findWinners 메서드는")
    @Nested
    class Describe_findWinners {

        @DisplayName("우승자가 1명인 경우")
        @Nested
        class Context_with_single_winner {

            @Test
            @DisplayName("가장 멀리 이동한 자동차 1명만 반환한다")
            void it_returns_one_winner() {
                // given: 위치가 각각 1, 2, 3인 자동차 리스트 생성
                MovingCar car1 = new MovingCar(new Name("lambo"));
                MovingCar car2 = new MovingCar(new Name("ferr"));
                MovingCar car3 = new MovingCar(new Name("pors"));

                // 수동으로 위치 조절 (전략 주입 활용)
                car1.move(() -> true); // loc: 1
                car2.move(() -> true); car2.move(() -> true); // loc: 2
                car3.move(() -> true); car3.move(() -> true); car3.move(() -> true); // loc: 3

                List<MovingCar> participants = List.of(car1, car2, car3);

                // when
                List<MovingCar> winners = judge.findWinners(participants);

                // then
                assertThat(winners).hasSize(1);
                assertThat(winners.get(0).getName()).isEqualTo("pors");
            }
        }

        @DisplayName("공동 우승자가 발생하는 경우")
        @Nested
        class Context_with_multiple_winners {

            @Test
            @DisplayName("가장 멀리 이동한 모든 자동차를 반환한다")
            void it_returns_multiple_winners() {
                // given: pobi와 jun이 똑같이 2칸 이동
                MovingCar car1 = new MovingCar(new Name("lambo"));
                MovingCar car2 = new MovingCar(new Name("ferr"));
                MovingCar car3 = new MovingCar(new Name("pors"));


                car1.move(() -> true); car1.move(() -> true); // loc: 2
                car2.move(() -> true); // loc: 1
                car3.move(() -> true); car3.move(() -> true); // loc: 2

                List<MovingCar> participants = List.of(car1, car2, car3);

                // when
                List<MovingCar> winners = judge.findWinners(participants);

                // then
                assertThat(winners).hasSize(2);
                assertThat(winners.get(0).getName()).isEqualTo("lambo");
                assertThat(winners.get(1).getName()).isEqualTo("pors");
            }
        }

        @DisplayName("모든 자동차가 이동하지 않은 경우")
        @Nested
        class Context_with_no_movement {

            @Test
            @DisplayName("모든 자동차를 공동 우승자로 반환한다")
            void it_returns_all_cars_as_winners() {
                // given: 모든 자동차가 위치 0
                MovingCar car1 = new MovingCar(new Name("lambo"));
                MovingCar car2 = new MovingCar(new Name("ferr"));
                List<MovingCar> participants = List.of(car1, car2);

                // when
                List<MovingCar> winners = judge.findWinners(participants);

                // then
                assertThat(winners).hasSize(2);
            }
        }
    }
}
