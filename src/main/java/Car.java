import java.util.Random;
import java.util.ArrayList;

public class Car
{
    private final Random random = new Random();
    private String carName = "";
    private int moveCount = 0;
    private int curPos = 0;

    public void setCarName(String name)
    {
        carName = name;
    }

    public String getCarName()
    {
        return carName;
    }

    public int getCarPos()
    {
        return curPos;
    }

    public int MoveCar()
    {
        moveCount += 1;
        int randomSpeed = random.nextInt(10);

        if (randomSpeed < 4)
            return curPos;

        curPos += randomSpeed;
        return curPos;
    }
}