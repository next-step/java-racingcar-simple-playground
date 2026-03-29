package racingcar.domain;


public class Position {

    private int value;

    public Position() {
        this(0);
    }

    public Position(int value) {
        this.value = value;
    }

    public int get() {
        return value;
    }

    public void forward() {
        try {
            value = Math.addExact(value, 1);
        } catch (ArithmeticException e) {
            throw new IllegalStateException("현재 위치에서 전진할 수 없습니다. 현재 위치: " + value, e);
        }
    }

}
