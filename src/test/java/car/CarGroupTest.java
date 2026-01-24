package car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import car.domain.model.CarGroup;
import car.domain.model.MovingCar;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CarGroupTest {

    private CarGroup carGroup;

    @BeforeEach
    void setUp() {
        carGroup = CarGroup.from(List.of("Car1", "Car2", "Car3"));
    }


    @DisplayName("moveAllCars 메서드는")
    @Nested
    class Describe_moveAllCars {

        @DisplayName("이동 전략을 받아서")
        @Nested
        class Context_with_moving_strategy {

            @DisplayName("각 자동차에 대해 move 메서드 호출한다")
            @Test
            void it_applies_strategy_to_all_cars() {

                // when
                carGroup.moveAllCars(() -> true);

                // then
                List<MovingCar> movingCars = carGroup.getCars();
                assertThat(movingCars).allSatisfy(car ->
                    assertThat(car.getLocation()).isEqualTo(1)
                );
            }
        }
    }

    @DisplayName("getCars 메서드는")
    @Nested
    class Describe_getCars {

        @DisplayName("반환된 리스트를 외부에서 수정하려고 하면")
        @Nested
        class Context_modify_returned_list {

            @Test
            @DisplayName("UnsupportedOperationException 예외를 발생시킨다")
            void it_throws_exception_when_modifying() {
                // given
                List<MovingCar> movingCars = carGroup.getCars();

                // when & then
                assertThatThrownBy(() -> movingCars.add(new MovingCar(new car.domain.model.Name("new"))))
                    .isInstanceOf(UnsupportedOperationException.class);
            }
        }
    }
}
