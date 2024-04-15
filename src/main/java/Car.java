import java.io.StreamCorruptedException;

public class Car {
    private String name;
    private int score;

    public Car(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public void move(){
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int randomNumber = randomNumberGenerator.generate();
        if (randomNumber > 4)   score++;
    }
}