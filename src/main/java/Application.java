import java.util.ArrayList;
import java.util.List;

import domain.Car;
import domain.FindWinner;
import domain.Racing;
import view.InputHandler;
import view.View;

public class Application {

    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        View view = new View();
        InputHandler inputHandler = new InputHandler();
        Racing racing = new Racing();
        FindWinner winnerFinder = new FindWinner();

        try {
            inputHandler.inputHandling();
        } catch (IllegalArgumentException e) {
            System.out.println(e);
        }

        String[] carNames = inputHandler.getCarNames();
        int number = inputHandler.getNumber();

        view.setNum(number);
        cars = racing.enrollCars(carNames);
        number = view.getNum();
        racing.startRacing(number);
        winnerFinder.FindLongestPosition(cars);

        List<String> winnerNames = winnerFinder.FindWinnerName(cars);

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
