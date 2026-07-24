import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import domain.Car;
import domain.FindWinner;
import view.*;

public class Application {

    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();

        // String input = "neo,brie,brown\n5\n";
        InputHandler inputHandler = new InputHandler();
        inputHandler.inputHandling();
        String[] carNames = inputHandler.getCarNames();
        int number = inputHandler.getNumber();

        View view = new View(carNames, number);

        try {
            cars = view.enrollCars();
        } catch (Exception e) {
            System.out.println(e);
        }
        number = view.getNum();

        FindWinner winnerFinder = new FindWinner(cars);
        winnerFinder.startRacing(number);
        winnerFinder.FindLongestPosition();
        List<String> winnerNames = winnerFinder.FindWinnerName();

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
