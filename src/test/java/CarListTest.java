import java.util.List;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CarListTest {
    public void moveTimes(Car car, int times) {
        for (int i=0; i< times; i++) {
            car.move(true);
        }
    }

    @Test
    void 우승자가_한명일때_한명_출력한다() {
        List<String> names = List.of("가", "나다", "라마바");
        CarList carList = new CarList(names);
        List<Car> car = carList.getCars();
        moveTimes(car.get(0), 4);
        moveTimes(car.get(1), 5);
        moveTimes(car.get(2), 2);

        List<String> winner = carList.findWinners();
        assertThat(winner).containsExactly("나다");
    }

    @Test
    void 우승자가_여러명일때_여러명출력한다() {
        List<String> names = List.of("가", "나다", "라마바", "아자차카");
        CarList carList = new CarList(names);
        List<Car> car = carList.getCars();
        moveTimes(car.get(0), 5);
        moveTimes(car.get(1), 2);
        moveTimes(car.get(2), 2);
        moveTimes(car.get(3), 5);

        List<String> winners = carList.findWinners();
        assertThat(winners).containsExactly("가", "아자차카");
    }
}
