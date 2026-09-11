import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private final List<Car> cars;

    public RacingGame(List<Car> cars) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("자동차가 필요합니다.");
        }

        this.cars = new ArrayList<>(cars);
    }

    public void race(int rounds){

        if (rounds < 0) {
            throw new IllegalArgumentException(
                    "횟수는 음수일 수 없습니다."
            );
        }

        for(int round = 0 ; round <rounds ; round++) {
            raceOneRound();
        }
    }

    private void raceOneRound(){
        for(Car car:cars){
            car.move(generateRandomNumber());
        }
    }

    private int generateRandomNumber() {
        return (int) (Math.random() * 10);
    }

    public List<String> getWinners(){
        int maxPosistion = findMaxPosition();
        List<String> winners = new ArrayList<>();
        for(Car car : cars){
            addWinnersName(car,maxPosistion,winners);
        }
        return winners;
    }

    private void addWinnersName(Car car, int maxPosition, List<String> winners){
        if(car.getPosition() == maxPosition){
            winners.add(car.getName());
        }

    }
    private int findMaxPosition(){
        int maxPosition = 0;
        for(Car car : cars){
            maxPosition = Math.max(car.getPosition(),maxPosition);
        }
        return maxPosition;
    }
}
