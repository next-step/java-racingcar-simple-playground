import java.util.ArrayList;
import java.util.List;

public class RacingController {
    public void run(){
        InputView inputView = new InputView();
        String[] carNames = inputView.inputCarNames();
        int attempt = inputView.inputAttempt();


        Cars cars = new Cars(makeCarList(carNames));

        OutputView outputView = new OutputView(cars);
        outputView.printResult(attempt);
        outputView.printWinner();
    }

    public List<Car> makeCarList(String[] carNames){
        List<Car> carList = new ArrayList<>();
        for (String carName: carNames){
            Car car = new Car(carName);
            carList.add(car);
        }
        return carList;
    }
}
