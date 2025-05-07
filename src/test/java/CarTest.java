import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    static MoveCondition moveCondition = new MoveConditionImpl();

    @Test
    @DisplayName("Car 객체 생성 시 이름이 정상적으로 저장된다")
    void carIsCreatedWithCorrectName() {
        Car car1 = new Car("A",moveCondition);
        Car car2 = new Car("B",moveCondition);

        assertThat(car1.getName()).isEqualTo("A");
        assertThat(car2.getName()).isEqualTo("B");
    }

    @Test
    @DisplayName("Car 객체 생성 시 이름이 정상적으로 저장된다")
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
    @DisplayName("주어진 횟수 동안 n대의 자동차 중에 우승자가 1명 이상 나온다")
    void whichCarIsWin() {
        Car carA = new Car("A",moveCondition);
        Car carB = new Car("B",moveCondition);
        Car carC = new Car("C",moveCondition);

        Car[] cars = {carA, carB, carC};

        int testRounds = 1;
        CarWinner winner = new CarWinner(cars);
        winner.whichWinner(testRounds);

        //우승자는 1명 이상 나온다
        assertThat(winner.getWinnerCnt()).isGreaterThanOrEqualTo(1);
        //우승자의 수와 이름의 수가 같아야 한다
        assertThat(winner.getWinnerCnt()).isEqualTo(winner.getWinnerName().size());

    }




}



