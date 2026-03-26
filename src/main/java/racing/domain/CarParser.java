package racing.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racing.domain.Car;

public class CarParser {
    public static List<Car> parse(String input){
        return Arrays.stream(input.split(",")).map(Car::new).collect(Collectors.toList());
    }
}
