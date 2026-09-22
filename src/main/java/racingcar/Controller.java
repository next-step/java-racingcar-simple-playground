package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView,OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
    public void run(){
        String namesInput=inputView.readCarNames();
        int countInput=inputView.readTryCount();
        List<Car> cars = createCars(namesInput);



    }

    private List<Car> createCars(String namesInput){
        String[] names=namesInput.split(",");
        List<Car> cars= new ArrayList<>();
        for(String name: names){
            cars.add(new Car(name));
        }
        return cars;

    }

}
