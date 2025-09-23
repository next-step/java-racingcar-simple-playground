import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RacingGameController {
    public void run() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        MoveCar moveCar = new MoveCar(random);
        Race race = new Race(moveCar);

        setupCars(scanner, race);
        setupRounds(scanner, race);
        runRace(race);
        printWinners(race);

        scanner.close();
    }

    private void setupCars(Scanner scanner, Race race) {
        System.out.println("Car Name: ");
        String[] carNames = scanner.nextLine().split(",");
        for (String name : carNames) {
            race.addCar(new Car(name.trim()));
        }
    }

    private void setupRounds(Scanner scanner, Race race) {
        System.out.println("Rounds: ");
        int rounds = scanner.nextInt();
        race.defineRounds(rounds);
    }

    private void runRace(Race race) {
        race.startRace();
    }

    private void printWinners(Race race) {
        List<String> winners = race.getWinners();
        System.out.println("Winners : " + String.join(", ", winners));
    }
}
