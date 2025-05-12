import domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.InputView;
import view.ResultView;

import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    static MoveCondition moveCondition = new MoveConditionImpl();

    @Test
    @DisplayName("domain.Car 객체 생성 시 이름이 정상적으로 저장된다")
    void carIsCreatedWithCorrectName() {
        Car car1 = new Car("A",moveCondition);
        Car car2 = new Car("B",moveCondition);

        assertThat(car1.getName()).isEqualTo("A");
        assertThat(car2.getName()).isEqualTo("B");
    }

    @Test
    @DisplayName("domain.Car 객체 생성 시 이름이 정상적으로 저장된다")
    void carIsCreatedWithCorrect() {
        Car car1 = new Car("A",moveCondition);
        Car car2 = new Car("B",moveCondition);

        assertThat(car1.getName()).isEqualTo("A");
        assertThat(car2.getName()).isEqualTo("B");
    }

    @Test
    @DisplayName("랜덤값이 4 이상이면 자동차가 전진한다")
    void carMovesWhenRandomValueIsGreaterThanOrEqualToThreshold() {
        Car car = new Car("A",moveCondition);
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤값이 3 이하면 자동차는 정지한다")
    void carDoesNotMoveWhenRandomValueIsLessThanThreshold() {
        Car car = new Car("A",moveCondition);
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차는 조건을 만족하면 이동을 누적한다")
    void carMultipleMove() {
        Car car = new Car("A",moveCondition);

        car.move(7); // 이동
        car.move(2); // 정지
        car.move(8); // 이동

        assertThat(car.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차 1개만 전진해서 우승하는 경우")
    void oneCarWin() {
        MoveCondition always = v -> true;
        MoveCondition never = v -> false;

        Car carA = new Car("A",always);
        Car carB = new Car("B",never);
        Car carC = new Car("C",never);

        Cars cars = new Cars(List.of(carA, carB, carC));

        int testRounds = 1;
        cars.moveAll(testRounds);

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
        MoveCondition never = v -> false;

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



