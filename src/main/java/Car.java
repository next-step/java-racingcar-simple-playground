public class Car {
    private final String name;
    private int location;
    private final NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        this.name = name;
        this.numberGenerator = numberGenerator;
        this.location = 0;
    }

    public Car(String name) {
        this.name = name;
        this.numberGenerator = new RandomNumberGenerator();
        this.location = 0;
    }

    public void move() {
        if(numberGenerator.getNumber() >= 4)
            location++;
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
