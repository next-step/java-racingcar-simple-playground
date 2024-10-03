package domain;

public class Car {
    private String name;
    private int position;

    //실제 사용되는 생성자
    public Car(String name) {
        this(name,0);
    }

    //단위 테스트를 위한 생성자
    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }

    //자동차 위치 이동하기
    public void moveCar(){
        if(CarControl.isMovable()){
            position++;
        }
    }

    public int getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }
}
