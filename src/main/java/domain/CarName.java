package domain;

public class CarName {
    private final String carName;

    public CarName(String name) {
        checkNull(name);
        checkLength(name);
        this.carName = name;
    }

    public String getCarName(){
        return carName;
    }

    private void checkNull(String carName) {
        if (carName == null || carName.isBlank()) {
            throw new IllegalArgumentException("이름은 공백으로 입력될 수 없습니다.");
        }
    }

    private void checkLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5자까지만 가능합니다.");
        }
    }
}
