package view;

import domain.Car;

import java.util.List;

public class OutputView {
    public OutputView() {
    }

    public void printWinners(List<Car> winners) {
        StringBuilder carNames = new StringBuilder();
        for (int i = 0; i < winners.size(); i++) {
            carNames.append(winners.get(i).getName().getValue());

            if (i != winners.size() - 1) {
                carNames.append(", ");
            }
        }

        System.out.println(carNames + "가 최종 우승했습니다");
    }

    public void printResult() {
        System.out.println("\n실행결과");
    }
}
