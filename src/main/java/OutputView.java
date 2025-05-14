import java.util.List;

public class OutputView {
    public static void displayWinners(List<String> winners){
        System.out.print("우승자 : ");
        for(String winner : winners){
            System.out.print(winner + ' ');
        }
    }

    public static void showCurrent(List<Car> cars){
        for(Car car: cars){
            String progress = "-".repeat(car.getLocation());
            System.out.println(car.getName() + " : " + progress);
        }
        System.out.println();
    }
}
