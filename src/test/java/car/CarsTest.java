package car;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("우승 자동차 구하기 테스트")
public class CarsTest {

    private Cars cars;

    @BeforeEach
    void setUp() {
        // 객체가 태어날 때부터 이미 자동차들을 품고 있음
        cars = new Cars(List.of("Car1", "Car2", "Car3"));
    }


    @DisplayName("moveAllCars 메서드는")
    @Nested
    class Describe_moveAllCars {

        @DisplayName("랜덤 정수값을 받아서")
        @Nested
        class Context_with_car_name_list {

            @DisplayName("각 자동차에 대해 move 메서드 호출한다")
            @Test
            void it_moves_all_cars_or_not_by_random_number() {
                // given
                List<Integer> randomValues = List.of(5, 3, 8);

                // when
                cars.moveAllCars(randomValues);

                // then
                List<MovingCar> carList = cars.getCars();
                assertThat(carList.get(0).getLocation()).isEqualTo(1); // Car1 이동
                assertThat(carList.get(1).getLocation()).isEqualTo(0); // Car2 이동하지 않음
                assertThat(carList.get(2).getLocation()).isEqualTo(1); // Car3 이동
            }
        }
    }

    @DisplayName("findWinners 메서드는")
    @Nested
    class Describe_findWinners {

        @DisplayName("단일 우승자가 발생하는 경우")
        @Nested
        class Context_with_single_winner {

            @Test
            @DisplayName("위치가 가장 높은 자동차를 반환한다")
            void it_returns_car_at_max_location() {
                // given: Car1만 전진시킴
                cars.moveAllCars(List.of(4, 0, 2));

                // when
                List<MovingCar> winners = cars.findWinners();

                // then
                assertThat(winners).hasSize(1)
                    .extracting(MovingCar::getName)
                    .containsExactly("Car1");
            }
        }

        @DisplayName("공동 우승자가 발생하는 경우")
        @Nested
        class Context_with_multiple_winners {

            @Test
            @DisplayName("위치가 가장 높은 모든 자동차를 반환한다")
            void it_returns_all_cars_at_max_location() {
                // given: Car1과 Car3만 전진시킴
                cars.moveAllCars(List.of(4, 0, 4));

                // when
                List<MovingCar> winners = cars.findWinners();

                // then
                assertThat(winners).hasSize(2)
                    .extracting(MovingCar::getName)
                    .containsExactly("Car1", "Car3");
            }
        }
    }
}