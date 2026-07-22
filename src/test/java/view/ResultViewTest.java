package view;

import static org.assertj.core.api.Assertions.assertThat;

import domain.Car;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultViewTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(output));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void printMultipleWinners() {
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");

        ResultView.printWinners(List.of(car1, car2));

        assertThat(output.toString())
                .isEqualTo("Car1, Car2가 최종 우승했습니다." + System.lineSeparator());
    }
}