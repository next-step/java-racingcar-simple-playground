import domain.Car;
import domain.Competition;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class JUnit5Test {

    @Nested
    class moveTest{

        @Test
        void move3(){
            Car car = new Car("TeCar", 0);
            car.moveCar(3);
            assertEquals(0, car.getPosition());
        }

        @Test
        void move4(){
            Car car = new Car("TeCar", 0);
            car.moveCar(4);
            assertEquals(1, car.getPosition());
        }
    }

    @Nested
    class competitionTest{

        @Test
        void runFixedValue() {
            Competition game = new Competition();

            game.joinCompetition("Kang");
            game.joinCompetition("dong");
            game.joinCompetition("ahn");

            game.runCompetition(4);

            for (Car car: game.getCars()){
                assertEquals(1, car.getPosition());
            }
        }
    }
}
