import java.util.ArrayList;
import java.util.List;

import domain.Car;
import domain.FindWinner;
import domain.Racing;
import view.View;

public class Application {

    public static void main(String[] args) {

        List<Car> cars = new ArrayList<>();
        View view = new View();
        Racing racing = new Racing();
        FindWinner winnerFinder = new FindWinner();

        String[] carNames = view.intro();
        int number = view.inputNum();

        cars = racing.enrollCars(carNames);
        cars = racing.startRacing(number, cars);

        view.printCarPosition(cars);

        int longestPosition = winnerFinder.findLongestPosition(cars);
        List<String> winnerNames = winnerFinder.findWinnerName(cars, longestPosition);

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
