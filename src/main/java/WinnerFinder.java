import java.util.ArrayList;
import java.util.List;

public class WinnerFinder {
  public List<Integer> findWinners(int[] carsPositions) {
    List<Integer> winners = new ArrayList<>();
    int maxPosition=getMaxPosition(carsPositions);

    for(int i=1;i<RaceInput.n;i++){
      if(carsPositions[i]==maxPosition){
        winners.add(i);
      }
    }

    return winners;
  }

  private int getMaxPosition(int[] carsPosition) {
    int max = 0;
    for(int i=1; i <= RaceInput.n;i++){
      if(carsPosition[i] > max){
        max = carsPosition[i];
      }
    }
    return max;
  }
}
