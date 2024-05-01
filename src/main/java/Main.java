import domain.Car;
import domain.Input;
import domain.Race;
import view.Print;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Race race = new Race();
        Input input = new Input();
        Print print = new Print();

        String[] nameList = input.separateNames(input.inputNames());

        int carCount = nameList.length;

        for (int i = 0; i < carCount; i++) {
            input.checkNameLength(nameList[i]);
        }

        int timeCount = input.timeCount();

        print.printResultHeader();

        ArrayList<Car> startRaceResult = race.startRace(race.initCar(nameList));
        print.printRacing(startRaceResult);

        for (int i = 0; i < timeCount - 1; i++) {
            startRaceResult = new ArrayList<>(race.startRace(startRaceResult));
            print.printRacing(startRaceResult);
        }

        ArrayList<String> winners = race.getWinner(startRaceResult);

        print.printWinners(winners);

    }
}
