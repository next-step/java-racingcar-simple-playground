import java.util.List;
import java.util.Scanner;

public class View {
    static Scanner input = new Scanner(System.in);

    public static String inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        return input.nextLine();
    }

    public static int inputTryCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        return input.nextInt();
    }

    public static void printRacingGame(List<Car> cars){
        String position = "-";
        for(Car car : cars){
            System.out.println(car.getName()+" : ");
            System.out.println(position.repeat(car.getPosition()));
            System.out.println("\n");
        }
    }
}
