import java.util.Random;

public class RacingCar {
    private final String name;
    private final Random random;
    private int position;

    // Random 객체를 생성자에서 받아옴
    public RacingCar(String name, Random random) {
        this.name = name;
        this.random = random;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    // 난수 0~9중 4 이상이 나오면 전진
    public boolean move() {
        int randomValue = random.nextInt(10);
        if (randomValue >= 4) {
            position++;
            return true; // 전진 성공
        }
        return false; // 전진 실패 (정지)
    }
}
