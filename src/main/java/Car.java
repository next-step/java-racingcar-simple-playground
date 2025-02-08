import java.util.Random;

public class Car
{
    String carName = new String();

    public void SetCarName(String name)
    {
        carName = name;
    }

    public int MoveCar()
    {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());
        int randomSpeed = random.nextInt(10);
        if (randomSpeed < 4)
            return 0;

        return randomSpeed;
    }
}