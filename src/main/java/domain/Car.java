package domain;

public class Car {
    private String name;
    private int location;

    public Car(String name) throws IllegalArgumentException {
        this.setName(name);
        this.location = 0;
    }

    //private 속성들에 대한 getter 및 setter
    public String getName() {
        return name;
    }
    public void setName(String name) throws IllegalArgumentException {
        if(name.length()>5){
            throw new IllegalArgumentException("name is must be less than 5 characters");
        }
        this.name = name;
    }
    public int getLocation() {
        return location;
    }

    //랜덤으로 speed 값을 생성하는 대신, speed를 파라미터로 입력받아 자동차를 이동
    public void move(int speed) throws IllegalArgumentException {
        if(speed > 9 || speed < 0){
            throw new IllegalArgumentException("speed is must be between 0 and 9");
        }
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
