import domain.Race;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RaceTest {
    int testCarCount = 3;
    int testRaceTurn = 5;

    @Test
    void 레이스의_우승자가_존재한다() {
        Race race = new Race(testCarCount, testRaceTurn);
        assertTrue(race.winner.size() >= 1);
    }
}
