import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import domain.Car;
import domain.Cars;
import domain.Race;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarRaceTest {

    @Test
    @DisplayName("자동차 이름이 5자를 초과하면 예외가 발생한다")
    void carNameLengthTest() {
        assertThatThrownBy(() -> new Car("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   ", "\t", "\n"})
    @DisplayName("자동차 이름이 null, 빈 문자열, 또는 공백이면 예외가 발생한다")
    void blankCarNameTest(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 빈 값일 수 없습니다");
    }

    @Test
    @DisplayName("3 이하면 전진, 4 이상이면 움직인다.")
    void moveTest() {

        Cars cars = new Cars(List.of("A", "B"));

        cars.moveAll(new FixNumberGenerator(new int[]{3, 4}));

        List<String> winners = cars.getWinner();

        assertThat(winners).hasSize(1);
        assertThat(winners).isEqualTo(List.of("B"));
    }

    @Test
    @DisplayName("자동차 목록에 중복된 이름이 존재하면 예외가 발생한다")
    void duplicateCarNamesTest() {
        List<String> duplicatedNames = List.of("pobi", "crong", "pobi");

        assertThatThrownBy(() -> new Cars(duplicatedNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다");
    }

    @Test
    @DisplayName("공백을 제거했을 때 중복되는 이름이 존재하면 예외가 발생한다")
    void duplicateCarNamesWithSpaceTest() {
        List<String> duplicatedNames = List.of("pobi", " crong", "crong ");

        assertThatThrownBy(() -> new Cars(duplicatedNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 중복될 수 없습니다");
    }

    @Test
    @DisplayName("자동차 수가 2대 미만이면 예외가 발생한다")
    void minimumCarCountTest() {
        List<String> singleCar = List.of("pobi");

        assertThatThrownBy(() -> new Cars(singleCar))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("최소 2대 이상");
    }

    @Test
    @DisplayName("단독 우승자 테스트")
    void getSingleWinnerTest() {

        int tryCount = 3;
        int[] fixedNumbers = new int[]{1, 2, 3, 2, 3, 4, 3, 4, 5};
        Race race = new Race("A,B,C", new FixNumberGenerator(fixedNumbers));

        for (int i = 0; i < tryCount; i++) {
            race.start();
        }

        List<String> winners = race.getWinners();

        assertThat(winners).containsExactly("C");
    }

    @Test
    @DisplayName("공동 우승자 테스트")
    void getCoWinnerTest() {

        int COUNT = 3;
        int[] fixedNumbers = new int[]{2, 4, 5, 3, 5, 9, 1, 4, 4};
        Race race = new Race("A,B,C", new FixNumberGenerator(fixedNumbers));

        for (int i = 0; i < COUNT; i++) {
            race.start();
        }

        List<String> winners = race.getWinners();

        assertThat(winners).hasSize(2);
        assertThat(winners).contains("B", "C");
    }
}
