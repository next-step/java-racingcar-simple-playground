import java.util.ArrayList;
import java.util.List;

public class Cars {
    static List<Car> cars;
    static String[] carNames;

    public static void splitCarName(String input){
        carNames = input.split(",");
    }

    private static int carSize(String[] carNames){
        return carNames.length;
    }

    static void generateCar(){
        cars = new ArrayList<>(carSize(carNames));
        for(String carName : carNames){
            cars.add(new Car(carName));

        }
    }

    public static void moveCars(){
        for(Car car : cars){
            car.moveCar();
        }
    }

}
