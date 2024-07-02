package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import view.OutputView;

public class Game {

    private List<Car> participantCars;

    public Game() {
        participantCars = new ArrayList<>();
    }

    public Game(List<Car> cars) {
        this.participantCars = new ArrayList<>(cars);
    }

    public void participateGame(Car car) {
        this.participantCars.add(car);
    }

    public void start(int round) {
        for (int i = 0; i < round; ++i) {
            for (Car car: participantCars) {
                car.move(ThreadLocalRandom.current().nextInt(10));
            }
            OutputView.printPosition(participantCars);
        }
    }

    public List<Car> getWinner() {
        int maxPosition = participantCars.stream()
            .max(Comparator.comparingInt(Car::getPosition))
            .get()
            .getPosition();

        return participantCars.stream()
            .filter(car -> car.getPosition() == maxPosition)
            .toList();
    }

    public List<Car> getParticipantCars() {
        return participantCars;
    }
}
