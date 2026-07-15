import java.util.ArrayList;
import java.util.List;

public class WinRacingCar {

    public int findMaxDistance(List<RacingCar> cars) {
        int maxDistance = 0;
        for(RacingCar car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }

        return maxDistance;
    }

    public void findWinner(RacingCar car, int maxDistance, List<RacingCar> winners) {
        if(maxDistance == car.getDistance()) {
            winners.add(car);
        }
    }

    public List<RacingCar> whoWin(List<RacingCar> cars) {
        int maxDistance = findMaxDistance(cars);
        List <RacingCar> winners = new ArrayList<>();

        for(RacingCar car : cars) {
            findWinner(car, maxDistance, winners);
        }

        return winners;
    }
}
