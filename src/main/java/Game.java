import java.util.Scanner;
import  java.util.Random;
public class Game {
    static Scanner in = new Scanner(System.in);

    public static String inputCarName(){
        return in.nextLine();
    }

    public static int inputRunNumber(){
        return in.nextInt();
    }

    public String[] splitInput(String carNameInput){
        return carNameInput.split(",");
    }

    public int randomPick(){
        return new Random().nextInt();
    }

    public static void runTest(){
        Game game = new Game();
        String name = inputCarName();
        System.out.println(new RacingCar(name).getCarName());
    }

    public static void main(String[] args){
        runTest();
    }
}
