package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.vo.Name;
import racingcar.domain.vo.Repetition;
import racingcar.domain.vo.Winners;
import racingcar.exception.ApplicationError;
import racingcar.exception.ApplicationException;
import racingcar.util.TestRandomNumberGenerator;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingGameTest {

    @Test
    @DisplayName("게임 생성 및 실행 테스트")
    void createRacingGame() {
        final Car car1 = new Car(new Name("car1"));
        final Car car2 = new Car(new Name("car2"));
        Repetition repetition = new Repetition(2);
        Cars cars = new Cars(Arrays.asList(car1, car2));

        RacingGame racingGame = new RacingGame(cars, new TestRandomNumberGenerator(new int[]{3, 4}));

        for (int i = 0; i < repetition.value(); i++) {
            racingGame.moveCars();
        }

        final Winners winners = racingGame.getWinners();

        assertThat(winners.countWinners()).isEqualTo(1);
        assertThat(car1.getPosition()).isZero();
        assertThat(car2.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("게임 생성 시, 중복된 이름이 존재 할 경우 예외 처리")
    void createRacingGameFailNameDuplicateException() {
        final Car car1 = new Car(new Name("car1"));
        final Car car2 = new Car(new Name("car1"));
        Repetition repetition = new Repetition(2);

        assertThatThrownBy(() -> new Cars(Arrays.asList(car1, car2)))
                .isInstanceOf(ApplicationException.class)
                .hasMessage(ApplicationError.DUPLICATE_NAME.getDescription());
    }

    @Test
    @DisplayName("공동 우승자 테스트")
    void multipleWinners() {
        final Car car1 = new Car(new Name("car1"));
        final Car car2 = new Car(new Name("car2"));
        final Car car3 = new Car(new Name("car3"));
        Repetition repetition = new Repetition(3);
        final Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        RacingGame racingGame = new RacingGame(cars,
                new TestRandomNumberGenerator(new int[]{9, 4, 2}));

        for (int i = 0; i < repetition.value(); i++) {
            racingGame.moveCars();
        }

        final Winners winners = racingGame.getWinners();

        assertThat(winners.value()).containsExactlyInAnyOrder(car1, car2);
        assertThat(winners.countWinners()).isEqualTo(2);
        assertThat(car1.getPosition()).isEqualTo(3);
        assertThat(car2.getPosition()).isEqualTo(3);
        assertThat(car3.getPosition()).isZero();
    }

    @Test
    @DisplayName("모든 자동차가 움직이지 않는 경우 테스트")
    void noCarsMove() {
        final Car car1 = new Car(new Name("car1"));
        final Car car2 = new Car(new Name("car2"));
        final Cars cars = new Cars(Arrays.asList(car1, car2));
        Repetition repetition = new Repetition(6);

        RacingGame racingGame = new RacingGame(cars,
                new TestRandomNumberGenerator(new int[]{3, 2}));

        for (int i = 0; i < repetition.value(); i++) {
            racingGame.moveCars();
        }

        final Winners winners = racingGame.getWinners();

        assertThat(winners.value()).containsExactlyInAnyOrder(car1, car2);
        assertThat(car1.getPosition()).isZero();
        assertThat(car2.getPosition()).isZero();
    }

    @Test
    @DisplayName("다수의 우승자 테스트")
    void complexMovementPattern() {
        final Car car1 = new Car(new Name("car1"));
        final Car car2 = new Car(new Name("car2"));
        final Car car3 = new Car(new Name("car3"));
        Repetition repetition = new Repetition(4);
        Cars cars = new Cars(Arrays.asList(car1, car2, car3));

        int[] values = {
                4, 3, 5,
                2, 7, 8,
                9, 1, 0,
                3, 4, 2
        };

        RacingGame racingGame = new RacingGame(cars, new TestRandomNumberGenerator(values));

        for (int i = 0; i < repetition.value(); i++) {
            racingGame.moveCars();
        }

        final Winners winners = racingGame.getWinners();

        assertThat(winners.value()).containsExactlyInAnyOrder(car1, car2, car3);
        assertThat(car1.getPosition()).isEqualTo(2);
        assertThat(car2.getPosition()).isEqualTo(2);
        assertThat(car3.getPosition()).isEqualTo(2);
    }
}
