package racingcar.domain;


public class Car {

    public record Name(String value) {

        public Name {
            if (value.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하여야 합니다");
            }
        }

    }


    public final Name name;

    private final Environment environment;
    private final Position position = new Position();

    public Car(Environment environment, Name name) {
        this.environment = environment;
        this.name = name;
    }

    public String getName() {
        return name.value;
    }

    public int getPosition() {
        return position.get();
    }

    public void tryAdvance() {
        Environment.MoveResult result = environment.tryAdvance();
        if (result == Environment.MoveResult.MOVE) {
            position.forward();
        }
    }

}
