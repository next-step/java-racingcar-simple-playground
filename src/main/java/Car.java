
import util.RandomUtil;

public class Car {

    private static final int RANDOM_LOWER_BOUND = 0;
    private static final int RANDOM_UPPER_BOUND = 9;
    private static final int MOVE_THRESHOLD = 4;

    private final String name;
    private int position;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int randomValue = RandomUtil.getRandomValue(RANDOM_LOWER_BOUND, RANDOM_UPPER_BOUND);
        if (randomValue >= MOVE_THRESHOLD) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void displayPosition() {
        System.out.println(name + " : " + "-".repeat(position));
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("자동차 이름은 비어있을 수 없습니다.");
        }
    }
}
