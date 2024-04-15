import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private Cars cars;

    public OutputView(Cars cars){
        this.cars = cars;
    }

    public void printResultTitle(){
        System.out.println("실행 결과");
    }

    public void printResultEachAttempt(int attempt){
        for (int i = 0;i<attempt;i++){
            cars.move();
            printResultEachCar();
            System.out.println();
        }
    }

    public void printResultEachCar(){
        for(Car car: cars.getCars()){
            System.out.print(car.getName() + " : ");
            for(int i = 0 ;i<car.getScore(); i++) System.out.print("-");
            System.out.println();
        }
    }

    public void printResult(int attempt){
        printResultTitle();
        printResultEachAttempt(attempt);
    }

    public void printWinner(){
        cars.findWinners();
        List<Car> winners = cars.getWinners();
        List<String> winnerNames = new ArrayList<>();
        for(Car winner: winners){
            winnerNames.add(winner.getName());
        }
        String winnerNameString = String.join(", ", winnerNames);
        System.out.println(winnerNameString + "가 최종 우승했습니다.");
    }
}
