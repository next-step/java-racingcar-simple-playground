import java.util.ArrayList;
import java.util.List;

import domain.Car;
import domain.FindWinner;
import domain.Racing;
import view.View;

public class Application {

    public static void main(String[] args) {
        List<List<Car>> wholeSnapShot = new ArrayList<>();
        List<Car> cars = new ArrayList<>();
        View view = new View();
        Racing racing = new Racing(cars);

        String[] carNames = view.intro();
        int number = view.inputNum();

        cars = racing.enrollCars(carNames);
        wholeSnapShot = racing.startRacing(number);
        FindWinner winnerFinder = new FindWinner(cars);

        view.printEachRoundCarPosition(wholeSnapShot);

        int longestPosition = winnerFinder.findLongestPosition();
        List<String> winnerNames = winnerFinder.findWinnerName(longestPosition);

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
