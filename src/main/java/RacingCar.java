import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class RacingCar {
    private String name;
    private int space = 0;

    public RacingCar(String name){
        this.name = name;
    }
    public int getSpace(){
        return space;
    }
    public String getName(){
        return name;
    }
    //랜덤 값을 받아오는 함수
    public int GetRandom(){
        Random random = new Random();
        return random.nextInt(10);
    }
    //랜덤값을 받고 자동차가 행동을 정하는 함수
    public void move(){
        int randomValue = GetRandom();
        if(randomValue >= 4) {
            space += 1;
        }
    }
    //누가 우승했는지 판단하는 함수
    public static List<RacingCar> findWinners(List<RacingCar> cars){
        List<RacingCar> winners = new ArrayList<>();
        int maxDistance = 0;

        for (RacingCar car : cars) {
            if (car.getSpace() > maxDistance){
                maxDistance = car.getSpace();
            }
        }

        for (RacingCar car : cars) {
            if (maxDistance == car.getSpace()) {
                winners.add(car);
            }
        }
        return winners;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(space);
    }
}