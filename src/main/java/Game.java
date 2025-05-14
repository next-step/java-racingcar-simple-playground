import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    public static void main(String[] args){
        List<Car> cars = setCars();
        Racing racing = new Racing(cars);

        int round = InputView.getRound();
        racing.start(round);

    }

    private static List<Car> setCars(){
        String input = InputView.getNames();
        List<String> names = splitNames(input);
        return createCars(names);
    }

    private static List<String> splitNames(String input){
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .collect(Collectors.toList());
    }

    private static List<Car> createCars(List<String> names){
        return names.stream()
                .peek(Game::validateName)
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private static void validateName(String name){
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다");
        }
    }
}
