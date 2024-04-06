package view;

public class ResultView {
    public void printWinners(String winnerNames) {
        String trimWinnerNames = winnerNames.trim();

        String[] winners = trimWinnerNames.split(" ");

        for (int i = 0; i < winners.length; i++) {
            System.out.print(winners[i]);

            if (i != (winners.length - 1)) {
                System.out.print(", ");
            }
        }

        System.out.println("가 최종 우승했습니다.");
    }
}
