import java.util.*;

class Car {
    // 필드
    private final String name;
    private int distance;

    // 생성자
    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    // 메소드

    // 자동자 움직인 후 상태 출력
    public void move() {
        Random random = new Random();
        int randomValue = random.nextInt(10);
        if (randomValue >= 4) {
            this.distance++;
        }
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.distance; i++) {
            System.out.print("-");
        }
        System.out.println();

    }

    // distance 반환
    public int getDistance() {
        return this.distance;
    }

    // name 반환
    public String getName() {
        return this.name;
    }
}