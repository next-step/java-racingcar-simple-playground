package view;

import domain.Car;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ResultViewTest {

    @Test
     void 우승자_이름을_올바르게_출력하는지_테스트() {
        List<Car> winnerCars = List.of(
                new Car("haeun"),
                new Car("ram"),
                new Car("com")
        );

        String expected = "haeun, ram, com";

        assertEquals(expected, String.join(", ",
                winnerCars.stream()
                        .map(Car::getName)
                        .toArray(String[]::new)));
    }
}
