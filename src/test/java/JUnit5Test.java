import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class JUnit5Test {
    @Test
    void testSingleWinner(){
        Competition competition = new Competition();
        competition.joinCompetition("audi");
        competition.joinCompetition("sonata");
        competition.joinCompetition("morning");

        competition.cars.get(0).setPosition(1);
        competition.cars.get(1).setPosition(2);
        competition.cars.get(2).setPosition(3);

        ArrayList<Car> winners = competition.getWinners();
        assertEquals(1, winners.size());
        assertEquals("morning", winners.get(0).getName());
    }

    @Test
    void testMultiWinner(){
        Competition competition = new Competition();
        competition.joinCompetition("audi");
        competition.joinCompetition("sonata");
        competition.joinCompetition("morning");

        competition.cars.get(0).setPosition(1);
        competition.cars.get(1).setPosition(3);
        competition.cars.get(2).setPosition(3);

        ArrayList<Car> winners = competition.getWinners();
        assertEquals(2, winners.size());
        assertEquals("sonata", winners.get(0).getName());
        assertEquals("morning", winners.get(1).getName());
    }
}
