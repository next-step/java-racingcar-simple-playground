public class Car {
    private int distance;
    private String name;
    private RandomNumberGenerator numberGenerator;

    Car(int distance, String name, RandomNumberGenerator randomNumberGenerator) {
        this.distance = distance;
        this.name = name;
        this.numberGenerator = randomNumberGenerator;
    }

    public int moving(){
        int random = numberGenerator.createRandomNumber();
        if (random>=4){
            distance++;
            return distance;
        }
        return distance;
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }
}
