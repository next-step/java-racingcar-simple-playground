import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RacingGame {
    private int rounds = 0;
    private List<Car> cars = new ArrayList<>();
    private List<Car> winners= new ArrayList<>();

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public void addCars(String name) {
        Car car = new Car(name);
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    private void sortCarsByNumberOfMoves() {
        cars.sort(Comparator.comparing(Car::getNumberOfMoves).reversed());
    }

    private void setWinners() {
        sortCarsByNumberOfMoves();
        int max_move = cars.get(0).getNumberOfMoves();
        for (Car car : cars) {
            if (cars.size() == 0 || car.getNumberOfMoves() != max_move) {
                return;
            }
            winners.add(car);
        }
    }

    public void play() {
        while (rounds-- > 0) {
            for (Car car : cars) {
                car.move();
            }
        }
        setWinners();
    }

    public List<Car> getWinners() {
        return winners;
    }
}
