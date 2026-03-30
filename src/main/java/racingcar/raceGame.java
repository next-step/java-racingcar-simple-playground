package racingcar;

import java.util.*;

public class raceGame {
    Racingcar[] carsInRacing;
    int numberOfCars;
    int numberOfWinners;

    public raceGame() {
        numberOfCars = 0;
        numberOfWinners = 0;
        carsInRacing = null;
    }


    String[] splitName(String str) {
        return str.split(",");
    }

    void doGame() {
        for (int i = 0; i < numberOfCars; i++) {
            carsInRacing[i].stopOrGo(carsInRacing[i].pickRandomInt());
            printDistance(carsInRacing[i]);
        }
        System.out.println("\n");
    }

    void checkNameIsUnderFive(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자 이하여야 합니다.");
        }
    }

    void setCars(String[] carNames) {
        numberOfCars = carNames.length;
        carsInRacing = new Racingcar[numberOfCars];
        for (int i = 0; i < numberOfCars; i++) {
            checkNameIsUnderFive(carNames[i]);
            carsInRacing[i] = new Racingcar(carNames[i]);
        }
    }

    void printDistance(Racingcar car) {
        System.out.print(car.carName + " : ");
        for (int i = 0; i < car.distanceFromStart; i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }

    String[] getWinner() {
        Arrays.sort(carsInRacing, Comparator.comparingInt((Racingcar p) -> p.distanceFromStart).reversed());
        numberOfWinners = 0;
        List<String> winners = new ArrayList<>();
        do {
            winners.add(carsInRacing[raceGame.this.numberOfWinners].carName);
            raceGame.this.numberOfWinners++;
        } while (carsInRacing[0].distanceFromStart
                == carsInRacing[raceGame.this.numberOfWinners].distanceFromStart);
        return winners.toArray(new String[raceGame.this.numberOfWinners]);
    }

    void printWinner() {
        String[] winners = getWinner();
        for (int i = 0; i < numberOfWinners - 1; i++) {
            System.out.print(winners[i] + ", ");
        }
        System.out.print(winners[numberOfWinners - 1] + "(이)가 최종 우승했습니다.");
    }
}
