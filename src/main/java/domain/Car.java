package domain;

public class Car {
    private CarName carName;
    private int position;

    //생성자
    public Car(String name) {
        this.carName = new CarName(name);
        this.position = 0;
    }

    //getter
    public CarName getCarName() {
        return carName;
    }

    public int getPosition() {
        return position;
    }

    //자동차 전진 메서드
    public void move(){
        position+=1;
    }

    // 자동차 상태 출력
    public void printPosition(){
        System.out.println(carName.getName() + " : "+ "-".repeat(position));
    }
}
