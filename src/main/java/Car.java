import java.util.Random;

public class Car {
    String name;
    int position;

    // 생성자 초기화 (Setter)
    public Car(String name, int position){
        this.name = name;
        this.position = position;
    }

    // 차 이동
    public void moveCar() {
        Random random = new Random();

        int num;
        num = random.nextInt(10);

        if (num >= 4){
            this.position += 1;
        }
    }
}
