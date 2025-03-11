import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RaceInput {
  public static int n;
  public static int round;

  public int[] startRace() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.print("자동차의 수를 입력하세요: ");
    n = Integer.parseInt(br.readLine());
    System.out.print("라운드 수를 입력하세요: ");
    round = Integer.parseInt(br.readLine());

    return runRaceRounds(n, round);
  }

  public int[] initializeCarsPosition(int carCount) {
    n = carCount;
    int[] carsPosition = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      carsPosition[i] = 0;
    }
    return carsPosition;
  }

  public int[] runRaceRounds(int carCount, int totalRounds) throws IOException {
    int[] carsPosition = initializeCarsPosition(carCount);
    int currentRound = 1;

    while (currentRound <= totalRounds) {
      carsPosition = MovingCar.simulateRound(n, currentRound, carsPosition);
      currentRound++;
    }
    return carsPosition;
  }

}
