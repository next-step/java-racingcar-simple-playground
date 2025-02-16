import java.util.*;
import java.util.stream.Collectors;

class RacingGame {

    private List<Car> cars;

    public RacingGame(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void gameStart(int rounds) {
        while (rounds-- > 0) {
            moveCars();
            System.out.println();
        }
    }

    private void moveCars() {
        Random random = new Random();
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            int randomValue = random.nextInt(10);
            car.move(randomValue);
            System.out.print("-".repeat(car.getPosition()));
            System.out.println();
        }
    }

    public List<Car> getWinner() {
        int maxPosition = getMaxPosition();
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toUnmodifiableList());
    }

    private int getMaxPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }

    public String findWinnerName(List<Car> winnerCars) {
        return winnerCars.stream()
                .map(car -> car.getName())
                .collect(Collectors.joining(", "));
    }
}