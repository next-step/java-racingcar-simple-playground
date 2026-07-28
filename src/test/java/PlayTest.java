import domain.Car;
import domain.Cars;
import domain.Play;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class PlayTest {
    @Test
    @DisplayName("우승자 구하기가 의도대로 작동하는지 테스트")
    void findWinnerTest() {
        //given
        Car car1 = new Car("소나타");
        Car car2 = new Car("아반떼");
        Car car3 = new Car("벤틀리");
        List<Car> testCar = new ArrayList<>();
        testCar.add(car1);
        testCar.add(car2);
        testCar.add(car3);
        Cars testCars = new Cars(testCar);
        SequentialNumberGenerator sequentialNumberGenerator =
                new SequentialNumberGenerator(List.of(
                        3, 4, 3, // 1라운드
                        3, 5, 4  // 2라운드
                ));
        Play play1 = new Play(testCars, sequentialNumberGenerator);

        //when
        for (int i = 0; i < 2; i++) {
            play1.playRound();
        }

        //then
        assertThat(testCars.getWinner()).containsExactly(car2);
    }

}
