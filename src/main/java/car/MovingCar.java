package car;

public class MovingCar {

    private static final int THRESHOLD = 4; // 임계값
    private final String name;
    private int location = 0;
    public MovingCar(String name) {
        validateName(name);
        this.name = name.trim();
    }

    private void validateName(String name) {
        // null이거나, 공백을 제거했을 때 빈 문자열인 경우 체크
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값일 수 없습니다.");
        }
        // 길이 제한 체크
        if (name.trim().length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
        }
    }

    public void move(int randomValue) {
        if (randomValue >= THRESHOLD) {
            forward();
        }
    }

    private void forward() {
        location += 1;
    }

    public int getLocation() {
        return location;
    }
    public String getName() {
        return name;
    }
}