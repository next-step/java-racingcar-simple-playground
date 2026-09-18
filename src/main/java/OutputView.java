import java.util.List;

public class OutputView {
    public void printCars(Cars cars) {
        for (Car car : cars.iterateCars()) {
            printCar(car);
        }
        System.out.println();
    }

    private void printCar(Car car) {
        System.out.print(car.getName() + " : ");

        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }

        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String[] winnerNames = new String[winners.size()];
        for (int i = 0; i < winners.size(); i++) {
            winnerNames[i] = winners.get(i).getName();
        }

        String joinedNames = String.join(", ",  winnerNames);

        System.out.println(joinedNames + "가 최종 우승했습니다.");
    }

    public void printResultHeader() {
        System.out.println();
        System.out.println("실행 결과");
    }
}
