import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

public class RaceTest {
    @ParameterizedTest
    @CsvSource({
            "3, false",
            "4, true",
            "0, false",
            "9, true"
    })

    void 숫자에_따라_이동가능여부가_결정된다(int number, boolean expected) {
        assertThat(Car.isMovable(number)).isEqualTo(expected);
    }

    @Test
    void 우승자가_한명일때_반환한다() {
        Car car1 = new Car("A");
        Car car2 = new Car("AB");
        Car car3 = new Car("ABC");
        Car car4 = new Car("ABCD");

        car1.move();
        car2.move(); car2.move(); car2.move(); car2.move();
        car3.move();
        car4.move(); car4.move(); car4.move();

        Cars cars = new Cars(List.of(car1, car2, car3, car4));
        Race race = new Race(cars);
        List<Car> winners = race.findWinners();
        assertThat(winners).extracting(Car::getName).containsExactly("AB");
    }

    @Test
    void 우승자가_한명이상일때_반환한다() {
       Car car1 = new Car("A");
       Car car2 = new Car("AB");
       Car car3 = new Car("ABC");
       Car car4 = new Car("ABCD");

       car1.move(); car1.move(); car1.move();
       car2.move(); car2.move(); car2.move(); car2.move();
       car3.move(); car3.move(); car3.move(); car3.move();
       car4.move();

       Cars cars = new Cars(List.of(car1, car2, car3, car4));
       Race race = new Race(cars);

       List<Car> winners = race.findWinners();
       assertThat(winners).extracting(Car::getName).containsExactly("AB", "ABC");
    }
}
