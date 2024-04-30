package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import view.ResultView;

public class RacingGame {
    private int tryCnt;
    private Car[] players;
    private final List<String> winners = new ArrayList<>();
    private int winnerMovingCnt;

    private final ResultView resultView = new ResultView();

    public RacingGame(String names, int tryCnt) {
        this.tryCnt = tryCnt;

        String[] playerName = names.split(",");

        players = new Car[playerName.length];

        players = Arrays.stream(names.split(","))
                .map(Car::new)
                .toArray(Car[]::new);

        for (int i = 0; i < playerName.length; i++) {
            players[i] = new Car(playerName[i]);
        }


    }

    public void race() {
        System.out.println("실행결과");
        countingPlayerMoving();
        countingWinnerMoving();
        decideWinner();
        setWinners();
    }

    public void countingPlayerMoving() {
        winnerMovingCnt = 0;

        for (int i = 0; i < tryCnt; i++) {
            for (int j = 0; j < players.length; j++) {
                players[j].moving();
                resultView.printMoving(players[j]);
            }

            System.out.println();
        }
    }

    public void countingWinnerMoving() {
        for (int i = 0; i < players.length; i++) {
            if (winnerMovingCnt < players[i].getMovingCnt()) {
                winnerMovingCnt = players[i].getMovingCnt();
            }
        }
    }

    public void decideWinner() {
        for (int i = 0; i < players.length; i++) {
            if (winnerMovingCnt == players[i].getMovingCnt()) {
                players[i].setWin(true);
            }
        }
    }

    public void setWinners() {

        for (int i = 0; i < players.length; i++) {
            if (players[i].getWin()) {
                winners.add(players[i].getCarName());
            }
        }
    }

    public List<String> getWinners() {
        return winners;
    }

    public int getWinnerMovingCnt() {
        return this.winnerMovingCnt;
    }

    public int getTryCnt() {
        return this.tryCnt;
    }

    public Car[] getPlayers() {
        return this.players;
    }
}
