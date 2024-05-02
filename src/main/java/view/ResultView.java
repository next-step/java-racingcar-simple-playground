package view;

import domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public void printWinners(List<String> winners) {

        String player = winners.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        System.out.println(player + "가 최종 우승했습니다.");
    }

    public void printMoving(Car player) {
        System.out.print(player.getCarName() + " : ");

        for (int i = 0; i < player.getMovingCnt(); i++){
            System.out.print("-");
        }

        System.out.println();
    }
}
