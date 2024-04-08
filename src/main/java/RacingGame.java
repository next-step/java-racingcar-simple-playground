import javax.sound.midi.SysexMessage;
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
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        Car car = new Car(name);
        cars.add(car);
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<Car> getWinners() {
        return winners;
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

    private void init() {
        cars.clear();
        winners.clear();
    }

    private void printCarInfo(Car car) {
        System.out.print(car.getName() + " : ");
        int num = car.getNumberOfMoves();
        while (num-- > 0) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinners() {
        Car winner = winners.remove(0);
        System.out.print(winner.getName());
        while (winners.isEmpty() == false) {
            winner = winners.remove(0);
            System.out.print(", " + winner.getName());
        }
        System.out.print("가 최종 우승했습니다.");
    }


    public void play() {
        while (rounds-- > 0) {
            for (Car car : cars) {
                car.move();
                printCarInfo(car);
            }
            System.out.println();
        }
        setWinners();
        printWinners();
        init();
    }
}
