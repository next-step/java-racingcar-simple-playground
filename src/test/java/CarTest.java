import racinggame.model.car.Car;
import racinggame.model.car.policy.numbergenerator.RandomGenerator;
import racinggame.model.car.policy.decider.MoveDecider;
import racinggame.model.car.policy.decider.ThresholdBaseMoveDecider;
import racinggame.model.car.policy.evaluator.GreaterThanOrEqualThresholdEvaluator;
import racinggame.model.car.policy.evaluator.ThresholdEvaluator;
import racinggame.model.car.policy.strategy.MoveStrategy;
import racinggame.model.car.policy.strategy.OneStepMoveStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("moveStrategy에 따라 누적 이동 거리가 쌓인다")
    void moveStrategy_따라_누적되는지_확인한다 () {
        // give
        MoveStrategy alwaysOne = () -> 1;
        Car car = new Car("car1", alwaysOne);

        // when
        car.move();
        car.move();

        // then
        assertThat(car.getMovedDistance()).isEqualTo(2);
        assertThat(car.getName()).isEqualTo("car2");
    }

    @DisplayName("이름을 null로 둔다면 에러를 던지는지 확인한다.")
    @Test
    void 이름을_null로_둘_수_없음(){
        // given
        MoveStrategy dummystrategy=()->0;

        // when & then
        assertThatThrownBy(()->new Car(null, dummystrategy))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 null 일 수 없습니다.");
    }

    @DisplayName("이름을 공백으로 둔다면 에러를 던지는지 확인한다.")
    @Test
    void 이름을_공백으로_둘_수_없음(){
        // given
        MoveStrategy dummystrategy=()->0;

        // when & then
        assertThatThrownBy(()->new Car(" ", dummystrategy))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름은 공백일 수 없습니다.");
    }


}
