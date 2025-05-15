import java.util.Random;

public class Car {

    //속성 : 이름, 위치 ,.랜덤 객체
    //메서드 : 이름 설정 생성자, 위치 설정 메서드
    public String name;
    public int location = 0;
    private IClass iclass;

    //사용자 입장
    public Car(String name) {
        this.name = name;
    }

    //테스트 용이성을 위해 오버라이딩 (random 고정을 위해서)
    public Car(String name, IClass iclass) {
        this.name = name;
        this.iclass = iclass;
    }

    public int moveCar() {
        int rand = iclass.giveInt();
        if (rand >= 4) {
            location++;
        }
        return location;
    }

    ;
}
