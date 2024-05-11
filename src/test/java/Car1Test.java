import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class Car1Test {
    @Test
    void CarTest() {
        NumberGenerator2 numberGenerator2 = new NumberGenerator2();
        Car car1 = new Car(0, "A", numberGenerator2);
        car1.moving();
        assertThat(car1.getDistance()).isEqualTo(0);

        NumberGenerator3 numberGenerator3 = new NumberGenerator3();
        Car car2 = new Car(0, "B", numberGenerator3);
        car2.moving();
        assertThat(car2.getDistance()).isEqualTo(1);
    }

    @Test
    void RacingTest() {
        RandomNumberGenerator numberGenerator = new RandomNumberGenerator();
        Car car1 = new Car(0, "A", numberGenerator);
        Car car2 = new Car(0, "B", numberGenerator);
        Car[] cars = {car1, car2};
        Racing ra = new Racing(cars);

        ra.carRacing(5);

        Car[] cars_tmp = ra.getCars();

        int expect_M = 0;
        for (Car car : cars_tmp) {
            expect_M = Math.max(expect_M, car.getDistance());
        }

        Car[] cars_cmp = ra.winCars();
        int M = cars_cmp[0].getDistance();

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