import static org.assertj.core.api.Assertions.assertThat;

import domain.Car;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import view.OutputView;

public class ViewTest {

    @Test
    public void testFormatCarInfo() {
        Car car = new Car("A", new MovableNumberGenerator());
        car.move();
        car.move();
        String formattedInfo = OutputView.formatCarInfo(car);
        assertThat(formattedInfo).isEqualTo("A : --");
    }

    @Test
    void testFormatWinnerNames() {
        List<String> winners = Arrays.asList("A", "B", "C");
        String formattedWinners = OutputView.formatWinnerNames(winners);

        assertThat(formattedWinners).isEqualTo("A, B, C");
    }

}
