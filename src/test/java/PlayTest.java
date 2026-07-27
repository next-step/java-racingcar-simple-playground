import domain.Car;
import domain.Cars;
import domain.Play;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

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
        SequentialNumberGenerator sequentialNumberGenerator = new SequentialNumberGenerator(new ArrayList<>(List.of(3, 4, 3)));
        sequentialNumberGenerator.addSequentialNumber(new ArrayList<>(List.of(3, 5, 4)));
        Play play1 = new Play(testCars, sequentialNumberGenerator);

        //when
        for (int i = 0; i < 2; i++) {
            play1.playRound();
        }

        //then
        assertSame(car2, testCars.getWinner().get(0));
        assertEquals(1, testCars.getWinner().size());
    }

}
