package racingcar.domain;

public class Car {
    private final String name;
    private int location;

    public Car(String name) {    //생성자
        this.name = name;
        if (name == null || name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 공백이 아닌 5자 이하 글자여야합니다.");
        }
        this.location = 0;
    }

    public String getName() {
        return this.name;
    }

    public int getLocation() {
        return this.location;
    }

    public void moveCar(int randomValue) {
        if (randomValue >= 4) {
            location += 1; //한번에 1씩 전진한다고 가정한다..
        }
    }

}

