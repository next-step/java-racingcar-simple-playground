import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingTest {

    @Test
    @DisplayName("자동차 이동 테스트")
    void movingTest(){
        final Car car1 = new Car("car1");
        final Car car2 = new Car("car2");
        final Car car3 = new Car("car3");

        car1.move(3);
        car2.move(4);
        car2.move(5);
        car3.move(7);

        assertThat(car1).extracting("location").isEqualTo(0);
        assertThat(car2).extracting("location").isEqualTo(2);
        assertThat(car3).extracting("location").isEqualTo(1);
    }

    @Test
    @DisplayName("우승자 식별 테스트")
    void getWinnerTest(){
        ByteArrayOutputStream printedMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(printedMessage));

        final Car car1 = new Car("car1");
        final Car car2 = new Car("car2");
        final Car car3 = new Car("car3");

        car1.move(2);
        car2.move(9);
        car2.move(9);
        car3.move(3);

        List<Car> cars = List.of(car1, car2, car3);
        Racing racing = new Racing(cars);
        racing.start(0);

        assertThat(printedMessage.toString()).contains("car2");
    }

    @Test
    @DisplayName("공동 우승자 식별 테스트")
    void getWinnersTest(){
        ByteArrayOutputStream printedMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(printedMessage));

        final Car car1 = new Car("car1");
        final Car car2 = new Car("car2");
        final Car car3 = new Car("car3");

        car1.move(2);
        car2.move(9);
        car3.move(9);

        List<Car> cars = List.of(car1, car2, car3);
        Racing racing = new Racing(cars);
        racing.start(0);

        assertThat(printedMessage.toString()).contains("car2");
        assertThat(printedMessage.toString()).contains("car3");
    }

    @Test
    @DisplayName("지동차 이름 길이 테스트")
    void nameLimitTest(){
        String input = "caaaaar,car";
        System.setIn(new java.io.ByteArrayInputStream(input.getBytes()));

        assertThrows(IllegalArgumentException.class, Game::new);
    }

    @Test
    @DisplayName("실행 과정 출력 테스트")
    void outputTest(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        Car car3 = new Car("car3");

        car1.move(5);
        car2.move(5);
        car3.move(5);

        List<Car> cars = List.of(car1, car2, car3);
        Racing racing = new Racing(cars);

        racing.start(0);


        String expectedOutput = "car1 : -\ncar2 : -\ncar3 : -\n";

        assertEquals(expectedOutput, outContent.toString());
    }

}
