package domain;

public class Car {
    private CarName name;
    private int position;

    //실제 사용되는 생성자
    public Car(CarName name) {
        this.name = name;
        position = 0;
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
        return name.getCarName();
    }
}
