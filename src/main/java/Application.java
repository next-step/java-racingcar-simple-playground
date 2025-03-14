import java.util.List;

public class Application {

  public static void main(String[] args) {
    CarFactory carFactory = new CarFactory();
    RaceInput.inputCars(carFactory);
    List<Car> cars = carFactory.getCars();
    int attempts = RaceInput.getAttempts();
    CarRunner.runRace(cars, attempts);
  }
}
