import domain.Car;
import domain.WinnerSelector;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WinnerTest {
    Car generateCarWithPosition(String name, int position) {
        Car car = new Car(name);

        for (int i = 0; i < position; i++){
            car.moveCar();
        }

        return car;
    }

    @DisplayName("우승자 찾기 테스트")
    @Test
    void getWinnersTest(){
        WinnerSelector winnerSelector = new WinnerSelector();

        List<Car> cars = new ArrayList<>();
        cars.add(generateCarWithPosition("car1", 1));
        cars.add(generateCarWithPosition("car2", 2));
        cars.add(generateCarWithPosition("car3", 2));
        cars.add(generateCarWithPosition("car4", 1));

        List<String> winners = winnerSelector.getWinners(cars);

        /*

        assertEquals(2, winners.size());
        assertTrue(winners.contains("car2"));
        assertTrue(winners.contains("car3"));

         */

        assertThat(winners).hasSize(2)
                .containsExactlyInAnyOrder("car2", "car3");
    }

    @DisplayName("우승자 위치 찾기 테스트")
    @Test
    void findWinnerPositionTest(){
        WinnerSelector winnerSelector = new WinnerSelector();

        List<Car> cars = new ArrayList<>();
        cars.add(generateCarWithPosition("car1", 1));
        cars.add(generateCarWithPosition("car2", 2));
        cars.add(generateCarWithPosition("car3", 2));
        cars.add(generateCarWithPosition("car4", 1));

        /*

        int winnerPosition = winnerSelector.findWinnerPosition(cars);

        assertEquals(2, winnerPosition);

         */

        int winnerPosition = winnerSelector.findWinnerPosition(cars);
        assertThat(winnerPosition).isEqualTo(2);
    }


}
