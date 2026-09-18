import domain.*;
import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // UI 객체들 생성
        Scanner scanner = new Scanner(System.in);
        InputView inputView = new InputView(scanner);
        OutputView outputView = new OutputView();

        // 이름 입력
        String[] names = inputView.readCarNames();

        // domain.Car 객체 생성
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            Car car = new Car(name);
            carList.add(car);
        }

        // domain.Cars 객체 생성
        Cars cars = new Cars(carList);

        // 경주 횟수 입력
        int raceCount = inputView.readRaceCount();

        // domain.RacingGame 생성
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        RacingGame racingGame = new RacingGame(cars, numberGenerator);

        // 경주 횟수만큼 라운드 반복
        outputView.printResultHeader();
        for (int i = 0; i < raceCount; i++) {
            racingGame.race();
            outputView.printCars(cars);
        }

        // 최종 자동차들 상태 출력
        outputView.printCars(cars);

        // 최종 우승자 출력
        outputView.printWinners(cars.findWinners());
    }
}
