import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class Car1Test {
    @Test
    void CarTest() {
        NumberGenerator2 numberGenerator2 = new NumberGenerator2();
        Car car1 = new Car("A", 0, numberGenerator2);
        car1.moving();
        assertThat(car1.distance).isEqualTo(0);

        NumberGenerator3 numberGenerator3 = new NumberGenerator3();
        Car car2 = new Car("B", 0, numberGenerator3);
        car2.moving();
        assertThat(car2.distance).isEqualTo(1);
    }

    @Test
    void RacingTest() {
        Racing ra = new Racing();
        ArrayList<String> l = new ArrayList<>();
        l.add("a");
        l.add("b");
        ra.racing(2, 5, l);//두 대의 자동차 다섯 번 경기 시켜야지
        ArrayList<Car> cars_tmp = ra.cars;
        int expect_M = 0;
        for (Car car : cars_tmp) {
            expect_M = Math.max(expect_M, car.distance);
        }

        ra.winner();
        int M = ra.winCars.get(0).distance;

        assertThat(expect_M).isEqualTo(M);
    }

    //오버라이딩 -> 랜덤값을 2로 지정
    private static class NumberGenerator2 extends RandomNumberGenerator {
        @Override
        public int createRandomNumber() {
            return 2;
        }
    }

    //오버라이딩 -> 랜덤값을 7로 지정
    private static class NumberGenerator3 extends RandomNumberGenerator {
        @Override
        public int createRandomNumber() {
            return 7;
        }
    }
}