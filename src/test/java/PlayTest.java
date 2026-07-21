import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class PlayTest {
    @Test
    @DisplayName("우승자 구하기가 의도대로 작동하는지 테스트")
    void findWinnerTest() {
        Car car1 = new Car("소나타");
        Car car2 = new Car("아반떼");
        Car car3 = new Car("벤틀리");
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        Play play1 = new Play(cars);
        play1.totalPlay(4);
        play1.getWinners(cars);
    }

}
