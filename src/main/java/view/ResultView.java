package view;

import domain.Car;
import java.util.List;

public class ResultView {
    public void printWinners(List<String> winners) {

        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i));

            if (i != winners.size() - 1) {
                System.out.print(", ");
            }
        }

        System.out.println("가 최종 우승했습니다.");
    }

    public void printMoving(Car player) {
        System.out.print(player.getCarName() + " : ");

        for (int i = 0; i < player.getMovingCnt(); i++){
            System.out.print("-");
        }

        System.out.println();
    }
}
