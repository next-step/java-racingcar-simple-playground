import java.util.ArrayList;
import java.util.List;

public class WinnerFinder {
  public List<Integer> findWinners(List<Car> cars) {
    List<Integer> winners = new ArrayList<>();
    int maxPosition=getMaxPosition(cars);

    for(int i=0;i<cars.size();i++){
      if(cars.get(i).getPosition()==maxPosition){
        winners.add(cars.get(i).getIndex());
      }
    }

    return winners;
  }

  private int getMaxPosition(List<Car> cars) {
    int max = 0;

    for (Car car : cars) {
      if (car.getPosition() > max) {
        max = car.getPosition();
      }
    }

    return max;
  }
}
