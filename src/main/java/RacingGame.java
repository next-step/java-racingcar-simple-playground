import java.util.*;
import java.util.stream.Collectors;

class RacingGame {

    private List<Car> cars = new ArrayList<>();
    private List<Car> winnerCars = new ArrayList<>();

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void gameStart(int rounds) {
        Random random = new Random();
        while (rounds-- > 0) {
            moveCars(random);
            System.out.println();
        }
    }

    public void moveCars(Random random) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            int randomValue = random.nextInt(10);
            car.move(randomValue);
            System.out.print("-".repeat(car.getPosition()));
            System.out.println();
        }
    }

    public List<Car> getWinner() {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0);
        winnerCars = cars.stream().filter(car -> car.getPosition() == maxPosition).collect(Collectors.toList());
        return winnerCars;
    }

    public String findWinnerName() {
        return winnerCars.stream().map(car -> car.getName()).collect(Collectors.joining(", "));
    }
}
