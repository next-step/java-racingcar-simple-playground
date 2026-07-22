package domain;

import domain.rand.Move;

import java.util.List;

public class RacingGame {

    private final List<RacingCar> carList;
    private final int turn;
    private int currentTurn;
    private final Move move;

    public RacingGame(List<RacingCar> cars, int turn, Move move) {
        this.carList = cars;
        this.turn = turn;
        this.currentTurn = 0;
        this.move = move;
    }

    public void start() {
        currentTurn++;
        moveAllCar();
    }

    public List<String> getWinnerNames() {

        int highestDistance = getHighestDistance();

        return getWinnerList(highestDistance).stream()
                .map(RacingCar::getName)
                .toList();
    }

    public List<RacingCar> getCarList() {
        return carList;
    }

    public boolean isFinished() {
        return currentTurn == turn;
    }

    private List<RacingCar> getWinnerList(int highestDistance) {
        return carList.parallelStream()
                .filter(car ->
                        car.getDistance() == highestDistance)
                .toList();
    }

    private void moveAllCar() {
        carList.stream()
                .forEach(car -> car.move(move.isMovable(move.getRandValue())));
    }

    private int getHighestDistance() {
        int highestDistance = 0;

        for (RacingCar car : carList) {
            highestDistance = compareDistance(car, highestDistance);
        }

        return highestDistance;
    }

    private int compareDistance(RacingCar car, int highestDistance) {

        if (car.getDistance() >= highestDistance) {
            highestDistance = car.getDistance();
        }

        return highestDistance;
    }
}
