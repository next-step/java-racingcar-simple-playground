package domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import view.ResultView;

public class RacingGame {
    private int tryCnt;
    private List<Car> players;
    private List<String> winners;
    private int winnerMovingCnt;

    private final ResultView resultView = new ResultView();

    public RacingGame(String names, int tryCnt) {
        this.tryCnt = tryCnt;

        players = Arrays.stream(names.split(","))
                .map(Car::new)
                .toList();
    }

    public void race() {
        System.out.println("실행결과");
        countingPlayerMoving();
        countingWinnerMoving();
        decideWinner();
    }

    public void countingPlayerMoving() {
        for (int i = 0; i < tryCnt; i++) {
            players.forEach(car-> {
                car.moving();
                resultView.printMoving(car);
            });
            System.out.println();
        }
    }

    public void countingWinnerMoving() {
        final Car winner = players.stream()
                .max(Comparator.comparing(Car::getMovingCnt))
                .stream()
                .findAny()
                .orElseThrow();

        winnerMovingCnt = winner.getMovingCnt();
    }

    public void decideWinner() {
        winners = players.stream()
                .filter(player -> player.getMovingCnt() == winnerMovingCnt)
                .map(Car::getCarName)
                .collect(Collectors.toList());
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

    public List<Car> getPlayers() {
        return this.players;
    }
}
