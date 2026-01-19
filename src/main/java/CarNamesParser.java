import java.util.ArrayList;
import java.util.List;

public final class CarNamesParser {

    public List<Car> parse(String input) {
        String[] tokens = input.split(",");
        List<Car> cars = new ArrayList<>();

        for (String token : tokens) {
            cars.add(new Car(token));
        }
        return cars;
    }
}