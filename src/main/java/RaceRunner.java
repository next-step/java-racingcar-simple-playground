import java.util.List;

public class RaceRunner {
  public static void main(String[] args) throws Exception {
    RaceInput raceInput = new RaceInput();
    int[] carsPosition = raceInput.startRace();
    WinnerFinder winnerFinder = new WinnerFinder();
    List<Integer> winners = winnerFinder.findWinners(carsPosition);
    System.out.println("우승한 차량: " + winners);
  }
}