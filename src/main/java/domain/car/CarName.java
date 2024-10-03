package domain.car;

public class CarName {
    private final String name;

    public CarName(String name) {

        if (name.length() > 5 || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다.");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
