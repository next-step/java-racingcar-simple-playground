package domain;

public class CarName {
    private final String carName;

    public CarName(String carName) {
        checkNull(carName);
        checkLength(carName);
        this.carName = carName;
    }

    private static void checkNull(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("이름은 공백으로 입력될 수 없습니다.");
        }
    }

    private static void checkLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 최대 5글자까지만 가능합니다. 입력값:" + carName);
        }
    }

    public String getCarName() {
        return carName;
    }
}
