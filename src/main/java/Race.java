import NumberGenerator.NumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final Cars cars;

    public Race(Cars cars){
        this.cars=cars;
    }

    public void start(NumberGenerator numberGenerator){
        cars.moveAll(numberGenerator);
    }

    public List<Car> getWinners(){
        return cars.getWinner();
    }

    public void getResult(){
        cars.printAll();
    }

}
