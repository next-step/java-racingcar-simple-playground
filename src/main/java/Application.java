import java.util.Scanner;

public class Application {

  public static void main(String[] args) {
    RaceInput raceInput = new RaceInput(new Scanner(System.in));
    Cars cars = raceInput.inputCars();
    int attempts = raceInput.getAttempts();
    CarRunner.runRace(cars, attempts);
  }
}

