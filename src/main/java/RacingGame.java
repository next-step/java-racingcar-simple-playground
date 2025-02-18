import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {
    private final List<RacingCar> racingCars = new ArrayList<>();
    private final Random random;
    private int runCount;

    public RacingGame(Random random){
        this.random =  random;
    }

    public void initializeGame(String[] carNames, int runCount) {
        this.runCount = runCount;
        for (String name : carNames) {
            racingCars.add(new RacingCar(name));
        }
    }

    public void playRound() {
        for (RacingCar car : racingCars) {
            car.move(random.nextInt(10));
        }
    }

    public int getRunCount() {
        return runCount;
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public List<String> findWinners() {
        int maxPosition = racingCars.stream()
                .mapToInt(RacingCar::getForwardCount)
                .max()
                .orElse(0);
        List<String> winners = new ArrayList<>();
        for (RacingCar car : racingCars) {
            if (checkWinner(car, maxPosition)) {
                winners.add(car.getCarName());
            }
        }
        return winners;
    }

    private boolean checkWinner(RacingCar car, int maxPosition){
        return car.getForwardCount() == maxPosition;
    }
}
