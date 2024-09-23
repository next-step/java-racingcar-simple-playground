import java.util.ArrayList;
import java.util.List;

public class Cars {
    static List<Car> cars;

    private static String[] splitCarName(){
        String input = View.inputCarName();
        String[] carNames = input.split(",");
        return carNames;
    }

    private static int carSize(String[] carNames){
        return carNames.length;
    }

    static void generateCar(){
        final List<Car> cars = new ArrayList<>(carSize(splitCarName()));
        for(String carName : splitCarName()){
            cars.add(new Car(carName));
        }
    }

    public static void moveCars(){
        for(Car car : cars){
            car.moveCar();
        }
    }

}
