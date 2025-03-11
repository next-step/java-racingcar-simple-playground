package CarGame;

import java.util.Random;

public class Car{
    private final String name;
    private int position=0;
    private int speed;
    public Car(String name) {
        this.name=name;
    }
    public void move() {
        speed=checkMove();
        if (speed>=4) {
            position+=speed;
        }
        printSpeed();
        printPosition();
    }
    public int checkMove() {
        Random random = new Random();
        speed = random.nextInt(10);
        return speed;
    }

    public int getPosition() {
        return position;
    }
    public String getName() {
        return name;
    }
    public void printPosition() {
        System.out.println(name + " 의 현재위치는 " + position);
        System.out.println("-------------");
    }
    public void printSpeed() {
        if(speed>=4)
            System.out.println(name + " 의 이동거리는 " + speed);
        else if(speed<=3) {
            System.out.println(name + " 의 이동거리는 0");

        }

    }
}