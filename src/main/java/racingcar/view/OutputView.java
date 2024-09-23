package racingcar.view;

import racingcar.model.Car;
import racingcar.model.WinnerCars;

import java.util.List;

public class OutputView {
    //<메소드>
    //우승자 출력
    public void PrintWhoIsWinner(List<Car> carList) {
        WinnerCars winnerCars = new WinnerCars(carList);
        List<Car> maxCarList = winnerCars.getWinningCars();
        List<String> carNames = maxCarList.stream().map(Car::getName).toList();  // Car 객체에서 이름을 추출
        String maxCarStr = String.join(", ", carNames);
        System.out.println(maxCarStr + "가 최종 우승했습니다.");
    }
}
