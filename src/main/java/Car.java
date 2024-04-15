import java.io.StreamCorruptedException;

public class Car {
    private String name;
    private int score;
    private RandomNumberGenerator randomNumberGenerator;

    public Car(String name){
        this.name = name;
    }

    public Car(String name, RandomNumberGenerator randomNumber){
        this.name = name;
        this.randomNumberGenerator = randomNumber;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public void move(){
        int randomNumber = randomNumberGenerator.generate();
        if (randomNumber > 4)   score++;
    }
}
