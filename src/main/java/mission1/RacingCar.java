package mission1;

public class RacingCar {
    private final String name;
    private int distance;
    public String getName() {
        return name;
    }

    public RacingCar(String name) {
        this.name = name;
        distance = 0;
    }
    public int getDistance() {
        return distance;
    }
    public void tryAdvance(int randomNum){
        if(randomNum >=4){
            distance++;
        }
    }
}
