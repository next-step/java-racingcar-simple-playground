package CarGame2;

import java.util.Random;

public class Car{
    private int carNum;
    private int position=0;
    private int speed;



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
    public int getCarNum(){
        return carNum;
    }
    public void setCarNum(int carNum){
        this.carNum=carNum;
    }

    public void printPosition() {
        // System.out.println(carNum+"의 현재 위치:"+position);
    }
    public void printSpeed() {
        // System.out.println(carNum+"의 이동 거리:"+speed);


    }
}