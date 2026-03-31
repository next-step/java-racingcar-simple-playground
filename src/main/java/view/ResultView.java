package view;

import domain.Car;

import java.util.ArrayList;

public class ResultView {
    public void printPlayResult(int tryCount, ArrayList<Car> cars) {
        System.out.println("실행 결과");
        for(int i=0; i<tryCount; i++) {
            for (Car car : cars) {
                System.out.print(car.getName() + " :");
                System.out.println(car.getMoveStatus());
            }
            System.out.println();
        }
    }

    public void printWinner(ArrayList<Car> cars) {
        ArrayList<String> winners = new ArrayList<>(cars.size());

        int highestMoveCount = 0;
        for(Car car: cars) {
            if (car.isWinner(highestMoveCount)) {
                highestMoveCount = car.getTotalMoveCount();
            }
        }

        // TODO: 일급 컬렉션으로 변경 필요
        for(Car car: cars) {
            if(car.getTotalMoveCount() == highestMoveCount) {
                winners.add(car.getName());
            }
        }

        String result = String.join(",", winners) + "가 최종 우승했습니다.";
        System.out.println(result);
    }
}
