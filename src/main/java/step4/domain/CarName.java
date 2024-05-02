package step4.domain;

import java.util.Objects;

public class CarName {

    private final String name;

    public CarName(String name){
        validateName(name);
        this.name=name;
    }

    private void validateName(String name)throws IllegalArgumentException{
        validateNotNUll(name);
        validateLength(name);
    }

    private void validateNotNUll(String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("자동차의 이름은 1글자 이상 5글자 이하로 지정하여야 합니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 1글자 이상 5글자 이하로 지정하여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
