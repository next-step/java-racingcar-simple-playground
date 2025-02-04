import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private final static Scanner scanner = new Scanner(System.in);
    private static Race race;
    private static int round;
    public static void main(String[] args) {
        inputFromUser();
        runRace();
        printWinner();
    }

    private static void inputFromUser(){
        //콘솔에서 한글이 깨져요 ㅠㅠ
        System.out.println("Enter names of cars which join the race (Names are separated by commas)");
        String value = scanner.nextLine();
        race = new Race(value);
        System.out.println("Enter rounds of race");
        round = scanner.nextInt();
    }

    private static void runRace(){
        System.out.println("Race result");
        race.runRace(round);
    }

    private static void printWinner(){
        List<Car> winners = race.getWinner();
        List<String> winnerNames = new ArrayList<>();
        for (Car winner : winners) {
            winnerNames.add(winner.getName());
        }

        String result = String.join(", ", winnerNames) + " is(are) winners";
        System.out.println(result);
    }
}
