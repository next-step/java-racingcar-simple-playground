package domain;

public class CreateCar {
    public static Car[] createCar(String[] carNames) {
        Car[] cars = new Car[carNames.length];

        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i].trim());
        }
        return cars;
    }
}
