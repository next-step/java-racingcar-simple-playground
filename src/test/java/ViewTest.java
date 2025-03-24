import static org.assertj.core.api.Assertions.assertThat;

import domain.Car;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import view.InputView;
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

    @Test
    public void testCheckLength() {
        List<String> names = Arrays.asList("HYUNDAI", "KIA", "FORD");
        Assertions.assertThatThrownBy(() -> InputView.checkLength(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCheckBlank() {
        List<String> names = Arrays.asList(" ", "KIA", "FORD");
        Assertions.assertThatThrownBy(() -> InputView.checkBlank(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCheckCarNumber() {
        List<String> names = Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L");
        Assertions.assertThatThrownBy(() -> InputView.checkCarNumber(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCheckDuplicates() {
        List<String> names = Arrays.asList("KIA", "KIA", "FORD");
        Assertions.assertThatThrownBy(() -> InputView.checkDuplicates(names))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
