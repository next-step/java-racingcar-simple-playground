import domain.Car;
import domain.MoveCar;
import domain.Race;
import view.Print;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        Race race = new Race();
        Print print = new Print();

        String[] nameList = race.sepNames(race.setNames());

        int carCount = nameList.length;

        for (int i = 0; i < carCount; i++) {
            race.checkNameLength(nameList[i]);
        }

        int timeCount = race.timeCount();

        System.out.println("\n실행 결과");

        Car[] startRaceResult = race.startRace(race.initCar(carCount, nameList), carCount);

        for (int i = 0; i < timeCount-1; i++) {
            startRaceResult = race.startRace(startRaceResult, carCount);
        }

        ArrayList<Car> winners = race.getWinner(startRaceResult);

        for (int i = 0; i < winners.size(); i++) {
            print.printWinners(winners, i);
        }

    }
}
