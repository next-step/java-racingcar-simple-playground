package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Nested
    @DisplayName("성공 케이스")
    class SuccessCases {

        @Test
        @DisplayName("초기 위치는 0이다")
        void initialPositionIsZero() {
            Car car = new Car(new Name("콜라"));

            Assertions.assertThat(car.getPosition()).isEqualTo(0);
        }

        @Test
        @DisplayName("이름은 생성자에서 설정한 Name과 같다")
        void carHasCorrectName() {
            Name name = new Name("제로");
            Car car = new Car(name);

            Assertions.assertThat(car.getName()).isEqualTo("제로");
        }

        @Test
        @DisplayName("NumberGenerator가 4 이상을 반환하면 위치가 1 증가한다")
        void carMovesWhenGeneratedNumberIsGreaterThanOrEqualToThreshold() {
            NumberGenerator generator = () -> 4;
            MoveCondition condition = new MoveCondition(generator);
            Car car = new Car(new Name("사이다"));

            car.move(condition);

            Assertions.assertThat(car.getPosition()).isEqualTo(1);
        }
    }

    @Nested
    @DisplayName("실패 케이스")
    class FailureCases {

        @Test
        @DisplayName("NumberGenerator가 3 이하를 반환하면 위치는 그대로 유지된다")
        void carDoesNotMoveWhenGeneratedNumberIsLessThanThreshold() {
            NumberGenerator generator = () -> 3;
            MoveCondition condition = new MoveCondition(generator);
            Car car = new Car(new Name("환타"));

            car.move(condition);

            Assertions.assertThat(car.getPosition()).isEqualTo(0);
        }
    }
}
