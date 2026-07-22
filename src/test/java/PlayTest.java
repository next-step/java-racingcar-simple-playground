import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class PlayTest {
    @Test
    @DisplayName("우승자 구하기가 의도대로 작동하는지 테스트")
    void findWinnerTest() {
        Car car1 = new Car("소나타");
        Car car2 = new Car("아반떼");
        Car car3 = new Car("벤틀리");
        List<Car> cars = new ArrayList<>();
        TestNumberGenerator testNumberGenerator = new TestNumberGenerator(9);
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        Play play1 = new Play(cars, testNumberGenerator);
        play1.totalPlay(4);
        play1.getWinners(cars);

        System.out.println("소나타 위치: " + car1.position);
        System.out.println("아반떼 위치: " + car2.position);
        System.out.println("벤틀리 위치: " + car3.position);
        System.out.println("우승자 수: " + play1.winner.size());

        assertSame(car2, play1.winner.get(0));
        assertEquals(1, play1.winner.size());
    }

}
