package mission2;

import mission1.RacingCar;
import mission4.NumberGenerator;

import java.util.*;

public class Racing {
    private final List<RacingCar> racingCarList;
    private final List<Map<String, Integer>> history;
    private final int gameCount;
    private final NumberGenerator numberGenerator;

    public Racing(String[] player, int gameCount, NumberGenerator numberGenerator) {
        this.gameCount = gameCount;
        this.history = new ArrayList<>();
        this.racingCarList = new ArrayList<>();
        this.numberGenerator = numberGenerator;
        init(player);
    }

    private void init(String[] player) {
        validateDuplicateNames(player);
        for (String s : player) {
            racingCarList.add(new RacingCar(s));
        }
    }

    private void validateDuplicateNames(String[] players) {
        List<String> names = new ArrayList<>();
        for (String name : players) {
            names.add(name);
        }
        Set<String> uniqueNames = new HashSet<>(names);
        if (names.size() != uniqueNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 허용하고 있지 않습니다.");
        }
    }


    public void start() {
        for (int i = 0; i < gameCount; i++) {
            history.add(roundResult());
        }
    }

    private void move() {
        for (RacingCar racingCar : racingCarList) {
            racingCar.tryAdvance(numberGenerator.numberGenerator());
        }
    }

    private Map<String, Integer> roundResult() {
        Map<String, Integer> result = new LinkedHashMap<>();
        move();
        for (RacingCar racingCar : racingCarList) {
            result.put(racingCar.getName(), racingCar.getDistance());
        }
        return result;
    }

    private int maxDistance() {
        int max = 0;
        for (RacingCar racingCar : racingCarList) {
            max = Math.max(max, racingCar.getDistance());
        }
        return max;
    }

    public List<String> getWinners() {
            List<String> winners = new ArrayList<>();
            int max = maxDistance();
            for (RacingCar racingCar : racingCarList) {
                addIfWinner(winners, racingCar, max);
            }
            return winners;
    }

    private void addIfWinner(List<String> winners, RacingCar racingCar, int max){
        if(racingCar.isWinner(max)){
            winners.add(racingCar.getName());
        }
    }

    public List<Map<String, Integer>> getHistory(){
        return history;
    }
}
