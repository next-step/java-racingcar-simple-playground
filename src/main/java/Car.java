import java.util.*;

public class Car {
    private String name;
    private int location;
    private static final Random rand = new Random();

    public Car(String name) {
        this.name = name;
        this.location = 0;
        validateName(name);
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 함");
        }
    }


    public int move() {
        int randomValue = rand.nextInt(10);

        if (randomValue >= 4) {
            return location++;
        }
        return location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
