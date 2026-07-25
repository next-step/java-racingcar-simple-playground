package domain;

public class Car {
    private String name;
    private int position = 0;

    public Car(String carName) {
        validateCarNameLength(carName);
        this.name = carName;
    }

    public void moveCar() {
        position += 1;
    }

    public void stopCar() {
        position += 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateCarNameLength(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }
}
