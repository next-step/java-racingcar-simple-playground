import NumberGenerator.NumberGenerator;
import java.util.List;
import java.util.stream.Collectors;

public class Race {

    private final Cars cars;
    private final int COUNT;

    public Race(String carNames, int n) {
        cars = new Cars(List.of(carNames.split(",")));
        COUNT = n;
    }

    public void start(NumberGenerator numberGenerator) {
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < COUNT; i++) {
            cars.moveAll(numberGenerator);
            getResult();
        }
        getWinners();
    }

    public List<Car> getWinners() {
        List<Car> winners = cars.getWinner();

        String result = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(result + "가 최종 우승했습니다.");

        return winners;
    }


    public void getResult() {
        cars.printAll();
        System.out.println();
    }

}
