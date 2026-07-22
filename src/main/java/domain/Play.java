package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Play {
    private List<Car> cars;
    private List<Car> winner;
    NumberGenerator numberGenerator;

    public Play(List<Car> cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.winner = new ArrayList<>();
        this.numberGenerator = numberGenerator;
    }

    public void playRound() {
        for (int i = 0; i < cars.size(); i++) { //라운드의 플레이 하나
            int presentNum = numberGenerator.generate();
            setState(presentNum, i);
        }
    }

    public void getWinners(List<Car> cars) {
        int maxNum = 0;
        maxNum = findMaxNum(cars);
        for (int i = 0; i < cars.size();i++) {
            findWinner(maxNum, cars, i);
        }
    }
    void findWinner(int maxNum, List<Car> cars, int i) {
        if (cars.get(i).getPosition() == maxNum) {
            winner.add(cars.get(i));
        }
    }

    int findMaxNum(List<Car> cars) {
        int carNum = cars.size();
        int[] scores = new int[carNum];
        for (int i = 0; i < carNum; i++) {
            scores[i] = cars.get(i).getPosition();
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
    public List<Car> getWinner() {
        return winner;
    }
    public List<Car> getCar() {
        return cars;
    }
}
