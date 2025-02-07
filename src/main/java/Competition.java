import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Competition {
    ArrayList<Car> cars = new ArrayList<>();

    public void joinCompetition(String name){
        cars.add(new Car(name, 0));
    }

    public void runCompetition(){
        for (Car car : cars){
            car.moveCar();
        }
    }

    private int getPositionMax(){
        ArrayList<Integer> positionList = new ArrayList<>();

        for (Car car : cars){
            positionList.add(car.getPosition());
        }

        return Collections.max(positionList);
    }

    public ArrayList<Car> getWinners(){
        int maxPosition = getPositionMax();
        return cars.stream()
                .filter(car -> isWinner(car, maxPosition))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private boolean isWinner(Car car, int maxPosition){
        return car.getPosition() == maxPosition;
    }
}
