package objectTmp;

import java.util.Random;

public class Car {
    private String name;

    public Car(String name){
        if (name.isEmpty()){
            throw new IllegalArgumentException();
        }

        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int move(){
        Random ran = new Random();
        if (ran.nextInt(10) >= 4){
            return 1;   // 한 칸 이동 (전진)
        }

        return 0;
    }

}