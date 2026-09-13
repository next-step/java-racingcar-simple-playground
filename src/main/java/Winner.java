import java.util.List;
import java.util.ArrayList;

public class Winner {

    public int findMaximum(List<Car> cars) {
        int maximum = 0;
        for (Car car : cars) {
            maximum = Math.max(maximum, car.getPosition());
        }
        return maximum;
    }

    public List<String> findWinners(List<Car> cars) {
        List<String> winners = new ArrayList<>();
        int maximum = findMaximum(cars) ;

        for (Car car : cars) {
            if(car.getPosition() == maximum){
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
