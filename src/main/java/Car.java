import java.util.Random;

public class Car {
    String name;
    int moving;
    int position;

    public Car(String name) {
        this.name = name;
        this.position=0;
        this.moving=-1;
    }

    public void insertRandomNumber(){
        Random r = new Random();
        moving=r.nextInt(10);
    }
    public void move(){
        if(moving>=4){
            this.position++;
            System.out.println("Go to move");
            return;
        }
        System.out.println("Stop");


    }
}
