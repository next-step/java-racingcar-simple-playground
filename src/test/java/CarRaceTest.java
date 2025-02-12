import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class CarRaceTest {

    private final CarRace cr = new CarRace();

    @Nested
    class testRace {
        @Test
        void shouldReturnSuccessOfCarRaceTest() {
            cr.setCarCount(9);
            cr.doRace(10);
            cr.setMaxPosition();
            System.out.println(cr.getWinnerCarNumber());
        }
    }
}
