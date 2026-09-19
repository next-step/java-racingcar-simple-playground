package view;

import domain.Car;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {

    @Test
    void readsCarsSeparatedByCommas() {
        // 준비
        String input = "neo,brie,brown";
        // 실행
        List<Car> cars = InputView.readCars(input);
        // 검증
        assertThat(cars)
                .extracting(Car::getName)
                .containsExactly("neo", "brie", "brown");
    }

    @Test
    void readsSingleCar() {
        // 준비
        String input = "neo";
        // 실행
        List<Car> cars = InputView.readCars(input);
        // 검증
        assertThat(cars)
                .extracting(Car::getName)
                .containsExactly("neo");
    }

    @Test
    void rejectsNegativeRounds() {
        // 준비
        String input = "-1";
        // 실행 및 검증
        assertThatThrownBy(() -> InputView.readRounds(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("횟수는 음수일 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "1.5", "", "2147483648"})
    void rejectsInvalidInteger(String input) {
        // 준비 : @Valuesource에서 잘못된 숫자 입력을 전달합니다
        // 실행 및 검증
        assertThatThrownBy(() -> InputView.readRounds(input))
                .isInstanceOf(NumberFormatException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", ",neo", "neo,", "neo,,brie", "neo, ", "neo,Greedy"})
    void rejectsInvalidCarNames(String input) {
        // 준비: @ValueSource에서 잘못된 자동차 이름 입력을 전달합니다
        // 실행 및 검증
        assertThatThrownBy(() -> InputView.readCars(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 1자 이상 5자 이하여야 합니다.");
    }
}
