import java.util.Random;

public class Car {
    private String name;
    Random ran = new Random();

    public Car(String name){
        this.name = name;
    }

    public int move(){
        if (ran.nextInt(10) >= 4){
            return 1;   // 한 칸 이동 (전진)
        }

        return 0;
    }
    
}