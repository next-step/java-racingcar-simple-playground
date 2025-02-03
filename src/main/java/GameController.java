import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class GameController {
    private final List<Car> carList = new ArrayList<>();
    private Random random = new Random();

    public void join(Car player) {
        carList.add(player);
    }

    public void start(int times) {
        while (times != 0) {
            carList.forEach(
                    car -> car.move(random.nextInt(10))
            );

            times--;
        }

        List<Car> winners = getWinners();

        System.out.println(winners);
    }

    public List<Car> getWinners() {
        int maxPos = carList.stream().mapToInt(Car::getPos).max().orElse(Integer.MIN_VALUE);

        return carList.stream().filter(
                car -> car.getPos() == maxPos
        ).collect(Collectors.toList());
    }
}
