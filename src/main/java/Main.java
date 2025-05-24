import domain.Car;
import service.RacingCars;

import java.util.List;
import java.util.Scanner;

import static util.InOutputView.inputCar;
import static util.InOutputView.inputTime;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Car> carList = inputCar(scanner);
        int time = inputTime(scanner);

        new RacingCars(carList)
                .playRound(time)
                .printWinner();
    }
}
