package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CarTest {

    @DisplayName("4이상이면 전진")
    @ParameterizedTest //얘는 이재 밑에를 반복해서 테스트 실행할꺼다. 라는 것을 선언? 알리는 것
    @ValueSource(ints = {4, 5, 6, 7, 8, 9}) //이 값들을 가지고 반복해서 실행한다.
    public void moveForwardWhenNumberIsFourOrMore(int number) {
        Car car = new Car("Test", 0);

        car.moveIfPossible(number);

        assertThat(car.getCarPosition()).isEqualTo(1);
    }

    @DisplayName("3이하면 그대로")
    @ParameterizedTest //얘는 이재 밑에를 반복해서 테스트 실행할꺼다. 라는 것을 선언? 알리는 것
    @ValueSource(ints = {0, 1, 2, 3}) //이 값들을 가지고 반복해서 실행한다.
    public void stayWhenNumberIsThreeOrLess(int number) {
        Car car = new Car("Test", 0);

        car.moveIfPossible(number);

        assertThat(car.getCarPosition()).isEqualTo(0);
    }

    //assertThatThrownBy() -->"이 코드를 실행했을 때 무슨 일이 일어나는지"(동작/행동)를 검증하는 것"
    //assertThat() -->"이미 있는 값"을 검증"
    @Test
    @DisplayName("이름이 null이거나 비어있으면 예외가 발생한다")
    void throwsException_whenNameIsNullOrBlank() {
        assertThatThrownBy(() -> new Car(null, 0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Car("  ", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 5자를 초과하면 예외가 발생한다")
    void throwsException_whenNameIsLongerThanFive() {
        assertThatThrownBy(() -> new Car("123456", 0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
