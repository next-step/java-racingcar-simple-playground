import java.util.Random;

public class Car {

    //속성 : 이름, 위치 ,.랜덤 객체
    //메서드 : 이름 설정 생성자, 위치 설정 메서드
    public String name;
    public int location = 0;
    private Random random;

    //사용자 입장
    public Car(String name) {
        this.name = name;
    }

    //테스트 용이성을 위해 오버라이딩 (random 고정을 위해서)
    public Car(String name, Random random) {
        this.name = name;
        this.random = random;
    }

    public int moveCar() {
        Random random = new Random();
        int rand = random.nextInt(10);

        if (rand >= 4) {
            location++;
        }
        return location;
    }

    ;
}
