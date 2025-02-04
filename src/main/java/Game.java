import java.util.Scanner;
import  java.util.Random;
public class Game {

    static Scanner in = new Scanner(System.in);

    public static String inputCarName(){
        return in.nextLine();
    }

    public static int inputRunCount(){
        int runCount;
        try{
            runCount = in.nextInt();
            runCountMinusCheck(runCount);
        }
        catch (NumberFormatException e) {
            throw new RuntimeException("정수만 가능합니다.");
        }
        return runCount;
    }

    public static void runCountMinusCheck(int runCount){
        if(runCount <= 0) throw new RuntimeException("실행횟수가 0이하 입니다.");
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
