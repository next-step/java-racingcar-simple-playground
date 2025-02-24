package modelTest;

import domain.Car;
import global.RandomUtil;
import global.TestNumberGenerator;

import global.SystemSetIn;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import service.RacingGameService;
import view.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    @DisplayName("Random숫자가 3이하인 경우 테스트")
    void ForwordOrStayIfNumberLessThan4() {
        RandomUtil testNumberGenerator = new TestNumberGenerator(3);

        Car car = new Car("avante", testNumberGenerator);
        car.moveForwardOrStay();

        assertThat(car.getMoveDistance())
                .as("car의 moveDistance는 증가 또는 감소하였으므로 기댓값인 1이 아닙니다.")
                .isEqualTo(1);
    }

    @Test
    @DisplayName("Random숫자가 4이상인 경우 테스트")
    void ForwordOrStayIfNumberMoreThan4() {
        RacingGameService racingGameService = new RacingGameService();
        RandomUtil testNumberGenerator = new TestNumberGenerator(4);
        Car car = new Car("avante", testNumberGenerator);

        car.moveForwardOrStay();

        assertThat(car.getMoveDistance())
                .as("car의 moveDistance는 2로 증가하지 않았습니다.")
                .isEqualTo(2);
    }

    @Test
    @DisplayName("Car객체 생성 시, 5자 이상의 Car 이름 에러 테스트")
    void validateInputNameTest() {
        String[] names = {"avente"};

        assertThatThrownBy(() -> Car.getInstancesByNames(names))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차의 이름은 5자 이내여야 합니다.");
    }

    @Test
    @DisplayName("시도할 회수가 음수일 경우, 에러 테스트")
    void getGameCountTest() {
        SystemSetIn.inputIntTestStrat(-2);

        InputView inputView = new InputView();

        AssertionsForClassTypes.assertThatThrownBy(() -> inputView.getGameCount())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("inputCount can't be less than 1");

        SystemSetIn.inputTestEnd();
    }
}
