import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

public class CarRaceTest {

    private final CarRace cr = new CarRace();

    @Nested
    class testRace {
        @Test
        void shouldReturnSuccessOfCarRaceTest() {
            cr.setCarCount(9);
            cr.doRace(10);
            System.out.println("우승자는" + cr.getWinnerCarNumber() + " 번 차량입니다");
        }
    }
}
