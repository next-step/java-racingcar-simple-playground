import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Play {
    List<Car> cars;
    List<Car> winner;
    NumberGenerator numberGenerator;

    public Play(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.winner = new ArrayList<>();
        this.numberGenerator = numberGenerator;
    }
    void totalPlay(int playNum) {
        for (int i = 0; i < playNum; i++) {
            playRound();
        }
    }
    void playRound() {
        for (int i = 0; i < cars.size(); i++) { //라운드의 플레이 하나
            int presentNum = numberGenerator.generate();
            setState(presentNum, i);
        }
    }

    void getWinners(List<Car> cars) {
        int maxNum = 0;
        maxNum = findMaxNum(cars);
        for (int i = 0; i < cars.size();i++) {
            findWinner(maxNum, cars, i);
        }
    }
    void findWinner(int maxNum, List<Car> cars, int i) {
        if (cars.get(i).position == maxNum) {
            winner.add(cars.get(i));
        }
    }

    int findMaxNum(List<Car> cars) {
        int carNum = cars.size();
        int[] scores = new int[carNum];
        for (int i = 0; i < carNum; i++) {
            scores[i] = cars.get(i).position;
        }
        Arrays.sort(scores);
        return scores[scores.length - 1];
    }

    void setState(int num, int i) {
        if (num >= 4) {
            cars.get(i).moveCar();
            return;
        }
        cars.get(i).stopCar();
    }
}
