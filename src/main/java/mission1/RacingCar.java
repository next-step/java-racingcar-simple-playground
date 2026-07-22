package mission1;

public class RacingCar {
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private final String name;
    private int distance;
    public String getName() {
        return name;
    }

    public RacingCar(String name) {
        validateName(name);
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

    public boolean isWinner(int distance){
        return this.distance == distance;
    }

    private void validateName(String name){
        if(name.length() > MAXIMUM_NAME_LENGTH){
            throw new IllegalArgumentException("이름의 길이가 " + MAXIMUM_NAME_LENGTH + "글자 이상은 불가능 합니다.");
        }
    }
}
