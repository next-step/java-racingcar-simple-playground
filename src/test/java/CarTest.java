import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private static final int MOVE_MIN = 4;
    private static final int NON_MOVE_UNDER = 3;


    @Test
    void move_Available(){

        //준비
        Car car = new Car("Greedy");

        //실행
        car.move(MOVE_MIN);

        //검즘
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void move_Impossible_Under(){
        //준비
        Car car = new Car("Greedy");

        //실행
        car.move(NON_MOVE_UNDER);

        //검즘
        assertThat(car.getPosition()).isEqualTo(0);
    }

}
