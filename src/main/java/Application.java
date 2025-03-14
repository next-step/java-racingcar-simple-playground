import java.util.List;
import java.util.Scanner;

public class Application {

  public static void main(String[] args) {
    CarFactory carFactory = new CarFactory();
    RaceInput raceInput=new RaceInput(new Scanner(System.in));
    raceInput.inputCars(carFactory);
    List<Car> cars = carFactory.getCars();
    int attempts = raceInput.getAttempts();
    CarRunner.runRace(cars, attempts);
  }
}
