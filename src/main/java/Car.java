import java.util.Random;

public class Car {
    private String name; // 자동차의 이름
    private int totalDistance = 0; // 이동한 누적 거리, 초기값은 0

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 랜덤값 반환 메서드
    private int randomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }

    // 자동차가 움직일지, 멈출지 검사하는 메서드
    public boolean isMove(int ranVal) {
        if (ranVal >= 4) return true; // 랜덤값이 4 이상이면 true
        return false; // 3 이하면 false
    }
    /*
    * 자동차를 움직이는 메서드 (중요! 테스트 위해 메서드 오버로딩으로 테스트용 메서드 구현할 것)
    * */

    // 1) 매개변수 직접 입력(테스트용)
    public void move(int ranVal) {
        if(isMove(ranVal)) totalDistance++;
    }
    // 2) 매개변수 X
    public void move() {
        if(isMove(randomValue())) totalDistance++;
    }

    // 누적 이동거리 반환하는 메서드
    public int getTotalDistance() {
        return this.totalDistance;
    }
}

