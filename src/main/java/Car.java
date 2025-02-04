import java.util.Random;

public class Car {
    private String name;
    private int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    //private 속성들에 대한 getter 및 setter
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getLocation() {
        return location;
    }

    //랜덤 speed 값을 생성하여 자동차를 이동
    public void move(){
        int speed = new Random().nextInt(10);
        this.location = calculateNextLocation(speed);

    }

    //speed값을 기준으로 다음 위치 계산
    private int calculateNextLocation(int speed){
        if(speed >= 4){
            return this.location+1;
        }
        return this.location;
    }





}
