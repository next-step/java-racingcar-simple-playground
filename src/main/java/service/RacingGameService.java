package service;

import domain.RacingCar.RacingCar;
import domain.RacingGame.RacingGame;
import java.util.ArrayList;
import java.util.List;

public class RacingGameService {

    public RacingGame initGame(List<RacingCar> participants) {
        RacingGame racingGame = new RacingGame();
        for (RacingCar participant : participants) {
            racingGame.addParticipant(participant);
        }
        return racingGame;
    }


    public void startGame(RacingGame racingGame, int maxCount) {
        int numberOfParticipants = racingGame.getNumberOfParticipants();
        List<Integer> randomNumbers;
        for (int tryCount = 1; tryCount <= maxCount; tryCount++) {
            randomNumbers = getRandomNumbers(numberOfParticipants);
            racingGame.race(randomNumbers);
        }
    }
    
    public List<RacingCar> getWinner(RacingGame racingGame) {
        return racingGame.getWinner();
    }

    private List<Integer> getRandomNumbers(int size) {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int index = 0; index < size; index++) {
            randomNumbers.add(getRandomNumber());
        }
        return randomNumbers;
    }

    private int getRandomNumber() {
        return (int) (Math.random() * 10);
    }

}
