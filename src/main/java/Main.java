import domain.Car;
import domain.MoveCar;
import domain.Race;
import view.Print;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Car car = new Car();
        MoveCar moveCar = new MoveCar();
        Race race = new Race();
        Print print = new Print();

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] nameList = race.sepNames(race.setNames());

        int carCount = nameList.length;

        for (int i = 0; i < carCount; i++) {
            race.checkNameLength(nameList[i]);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int timeCount = race.timeCount();

        System.out.println("실행 결과");

        Car[] startRaceResult = race.startRace(race.initCar(carCount, nameList), carCount);

        // startRace에서 출력
        for (int i = 0; i < timeCount; i++) {
            startRaceResult = race.startRace(startRaceResult, carCount);
        }

        ArrayList<Car> winners = race.getWinner(startRaceResult);


        if (winners.size() == 1) {
            System.out.print(winners.get(0).getName());
            System.out.println("가 최종 우승했습니다.");
            return;
        }

        for (int i = 0; i < winners.size(); i++) {
            print.printWinners(winners, i);
        }
//        System.out.println("가 최종 우승했습니다.");
    }
}
