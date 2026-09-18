public class OutputView {
    public void printCars(Cars cars) {
        for (Car car : cars.iterateCars()) {
            printCar(car);
        }
    }

    private void printCar(Car car) {
        System.out.print(car.getName() + " : ");

        for (int i = 0; i < car.getPosition(); i++) {
            System.out.print("-");
        }

        System.out.println();
    }
}
