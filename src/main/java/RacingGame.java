import model.Car;
import view.OutputController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RacingGame {
    private final OutputController outputController = new OutputController();
    private final List<Car> carList = new ArrayList<>();
    private final Random random = new Random();

    public void join(Car player) {
        carList.add(player);
    }

    public void race(int times) {
        while (times != 0) {
            carList.forEach(
                    car -> car.move(random.nextInt(10))
            );

            outputController.printProgressResult(carList);

            times--;
        }
    }

    public void printWinners() {
        List<Car> winners = getWinners();
        outputController.printWinners(winners);
    }

    public List<Car> getWinners() {
        int maxPos = carList.stream().mapToInt(Car::getPos).max().orElse(Integer.MIN_VALUE);

        return carList.stream().filter(
                car -> car.getPos() == maxPos
        ).collect(Collectors.toList());
    }

    public List<Car> getCarList() {
        return carList;
    }
}
