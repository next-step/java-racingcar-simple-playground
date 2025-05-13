package racingcar.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinnersTest {

    @Test
    @DisplayName("우승자가 없는 경우 countWinners는 0을 반환해야 한다")
    void countWinnersReturnsZeroWhenNoWinners() {
        Winners winners = new Winners(Collections.emptyList());

        int count = winners.countWinners();

        assertThat(count).isZero();
    }

    @Test
    @DisplayName("우승자가 한 명인 경우 countWinners는 1을 반환해야 한다")
    void countWinnersReturnsOneWhenSingleWinner() {
        Car car = new Car(new Name("car1"));
        Winners winners = new Winners(List.of(car));

        int count = winners.countWinners();

        assertThat(count).isEqualTo(1);
    }

    @Test
    @DisplayName("우승자가 여러 명인 경우 countWinners는 우승자 수를 반환해야 한다")
    void countWinnersReturnsCorrectCountWhenMultipleWinners() {
        Car car1 = new Car(new Name("car1"));
        Car car2 = new Car(new Name("car2"));
        Car car3 = new Car(new Name("car3"));

        Winners winners = new Winners(Arrays.asList(car1, car2, car3));

        int count = winners.countWinners();

        assertThat(count).isEqualTo(3);
    }

    @Test
    @DisplayName("value 메서드는 우승자 목록을 반환해야 한다")
    void valueShouldReturnListOfWinners() {
        Car car1 = new Car(new Name("car1"));
        Car car2 = new Car(new Name("car2"));
        List<Car> winnersList = Arrays.asList(car1, car2);

        Winners winners = new Winners(winnersList);

        List<Car> result = winners.value();

        assertThat(result).isEqualTo(winnersList);
        assertThat(result).containsExactly(car1, car2);
    }

    @Test
    @DisplayName("동일한 우승자 목록을 가진 Winners 객체는 equals에서 true를 반환해야 한다")
    void equalsShouldReturnTrueForSameWinners() {
        Car car1 = new Car(new Name("car1"));
        Car car2 = new Car(new Name("car2"));

        List<Car> firstList = Arrays.asList(car1, car2);
        List<Car> secondList = Arrays.asList(car1, car2);

        Winners winners1 = new Winners(firstList);
        Winners winners2 = new Winners(secondList);

        assertThat(winners1).isEqualTo(winners2);
        assertThat(winners1.hashCode()).isEqualTo(winners2.hashCode());
    }
}