package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RaceJudgeTest {
    @Test
    @DisplayName("자동차 1개만 전진해서 우승하는 경우")
    void oneCarWin() {
        MoveCondition always = v -> true;
        MoveCondition never = v -> false;

        Car carA = new Car("A", always);
        Car carB = new Car("B", never);
        Car carC = new Car("C", never);

        Cars cars = new Cars(List.of(carA, carB, carC));
        cars.moveAll(1);

        RaceJudge result = new RaceJudge(cars);

        assertThat(result.getWinnerCount()).isEqualTo(1);
        assertThat(result.getWinnerNames()).containsExactly("A");
    }

    @Test
    @DisplayName("자동차 2개가 공동 우승하는 경우")
    void twoCarWin() {
        MoveCondition always = v -> true;
        MoveCondition never = v -> false;

        Car carA = new Car("A", always);
        Car carB = new Car("B", always);
        Car carC = new Car("C", never);

        Cars cars = new Cars(List.of(carA, carB, carC));
        cars.moveAll(1);

        RaceJudge result = new RaceJudge(cars);

        assertThat(result.getWinnerCount()).isEqualTo(2);
        assertThat(result.getWinnerNames()).containsExactlyInAnyOrder("A", "B");
    }

    @Test
    @DisplayName("자동차 3개가 공동 우승하는 경우")
    void threeCarWin() {
        MoveCondition always = v -> true;

        Car carA = new Car("A", always);
        Car carB = new Car("B", always);
        Car carC = new Car("C", always);

        Cars cars = new Cars(List.of(carA, carB, carC));
        cars.moveAll(1);

        RaceJudge result = new RaceJudge(cars);

        assertThat(result.getWinnerCount()).isEqualTo(3);
        assertThat(result.getWinnerNames()).containsExactlyInAnyOrder("A", "B", "C");
    }

}