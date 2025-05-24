package domain;

public class Car {

    //속성 : 이름, 위치 , 랜덤객체 주입
    //메서드 : 이름 설정 생성자, 위치 설정 메서드
    private String name;
    private int location = 0;

    private NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public int moveCar() {
        int rand = numberGenerator.generateInt();
        if (rand >= 4) {
            location++;
        }
        return location;
    }

    public String getName() {
        return name;
    }

    public int getLocation() {
        return location;
    }
}
