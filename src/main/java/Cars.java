import java.util.ArrayList;
import java.util.List;

public class Cars {
    private List<Car> cars;
    private int maxScore;
    private List<Car> winners = new ArrayList<>();

    public Cars(List<Car> cars){
        this.cars = cars;
    }

    public List<Car> getCars(){
        return cars;
    }

    public void move(){
        for(Car car : cars){
            car.move();
        }
    }

    public void findMaxScore(){
        for(Car car: cars){
            checkMaxScore(car);
        }
    }

    public void checkMaxScore(Car car){
        if (maxScore < car.getScore())  maxScore = car.getScore();
    }

    public void findWinners(){
        findMaxScore();
        for(Car car: cars){
            checkWinner(car);
        }
    }

    public void checkWinner(Car car){
        if(maxScore == car.getScore()) {
            winners.add(car);
        }
    }

    public List<Car> getWinners(){
        return winners;
    }
}
