package domain;

public class Car {
    private String name;
    private int position;

    public Car(String name, int position){
        this.name = name;
        this.position = position;
    }

    public int getPosition(){
        return this.position;
    }

    public String getName(){
        return this.name;
    }

    // 차 이동
    public void moveCar(int value) {
        if (value >= 4){
            this.position += 1;
        }
    }
}
