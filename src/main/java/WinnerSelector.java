import java.util.ArrayList;
import java.util.List;

public class WinnerSelector {
    private static List<String> winners = new ArrayList<>();

    public static List<String> getWinners(List<Car> cars){
        int winnerPosition = findWinnerPosition(cars);

        for(Car car : cars){
            addWinner(car,winnerPosition);
        }

        return winners;
    }

    private static int findWinnerPosition(List<Car> cars){
        return cars.stream()
                .map(Car::getPosition)
                .reduce(Integer::max)
                .orElse(0);
    }

    private static void addWinner(Car car, int winnerPosition){
        if(car.getPosition()==winnerPosition){
            winners.add(car.getName());
        }
    }
}
