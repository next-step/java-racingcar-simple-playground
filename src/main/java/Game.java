import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {

    List<Car> carList = new ArrayList<>();
    List<Car> winnerList = new ArrayList<>();

    public void playGame(int carNum, int roundNum) {
        initGame(carNum);
        for (int i = 0; i < roundNum; i++) {
            playRound();
        }
        makeWinnerList();
    }

    public void initGame(int carNum) {
        for (int i = 0; i < carNum; i++) {
            carList.add(new Car("Car_" + i));
        }
    }

    public void playRound() {
        for (Car car : carList) {
            car.move(getRandom());
        }
    }

    public int getRandom() {
        return new Random().nextInt(10);
    }

    public void makeWinnerList() {
        int maxDistance = getMaxDistance();
        for (Car car : carList) {
            addWinner(car, maxDistance);
        }
    }

    private void addWinner(Car car, int maxDistance) {
        if (car.isSamePosition(maxDistance)) {
            winnerList.add(car);
        }
    }

    private int getMaxDistance() {

        int maxDistance = 0;
        for (Car car : carList) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }
}
