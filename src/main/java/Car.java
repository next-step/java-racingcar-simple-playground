public class Car {

    //속성 : 이름, 위치 , 랜덤객체 주입
    //메서드 : 이름 설정 생성자, 위치 설정 메서드
    public String name;
    public int location = 0;
    private IClass iclass;

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
