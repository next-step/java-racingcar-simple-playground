package domain;

public class RacingGame {
    private int tryCnt;
    private Car[] players;
    private String winners;
    private int winnerMovingCnt;

    public RacingGame(String names, int tryCnt) {
        this.tryCnt = tryCnt;

        String[] playerName = names.split(",");

        players = new Car[playerName.length];

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
                players[j].addMovingCnt(players[j].Moving());
                printMoving(players[j]);
            }

            System.out.println();
        }
    }

    public void printMoving(Car player) {
        System.out.print(player.getName() + " : ");

        for (int i = 0; i < player.getMovingCnt(); i++){
            System.out.print("-");
        }

        System.out.println();
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
                winners = players[i].getName() + " ";
            }
        }
    }

    public String getWinners() {
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
