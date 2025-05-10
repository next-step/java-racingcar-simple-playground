import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class RacingGame {
    /**
     * n대의 자동차가 참여할 수 있다.
     * 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
     * 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
     * 자동차 경주 게임을 완료한 후 누가 우승했는지를 구할 수 있다. 우승자는 한 명 이상일 수 있다.
     */
    private RacingCar[] racingCar;          // 자동차를 담을 수 있는 배열 생성
    private int winnerNum;                  // 우승 자동차의 수
    private ArrayList<String> winnerName;   // 우승 자동차 이름
    private int winnerPosition;             // 우승 자동차의 위치

    public RacingGame(RacingCar[] racingCar){
        this.racingCar = racingCar;
        this.winnerNum = 0;
        this.winnerName = new ArrayList<>();
        this.winnerPosition = Integer.MIN_VALUE;
    }

    public int getWinnerNum() {
        return winnerNum;
    }

    public int getWinnerPosition() {
        return winnerPosition;
    }

    public List<String> getWinnerName() {
        return winnerName;
    }

    public void runRace(int testRound) {
        moveAllRacingCar(testRound);
        countWinner();
        saveWinnerName();
    }

    private void moveAllRacingCar(int testRound) {
        IntStream.range(0, testRound)
                .forEach(i -> Arrays.stream(racingCar).forEach(car -> car.move(RandomNumber.numberStatus())));

    }

    private void countWinner() {    // 우승 자동차 판별 메소드
        for (RacingCar racingCar : racingCar) {
            updateWinnerCount(racingCar);
        }
    }

    private void updateWinnerCount(RacingCar racingCar) {
        int position = racingCar.getPosition();
        if (position > winnerPosition) {
            winnerNum = 1;
            winnerPosition = position;
        }
        if (position == winnerPosition) {
            winnerNum ++;
            // 우승자가 2명 이상이라면 수를 증가시켜주자
        }
    }

    private void saveWinnerName() {
        Arrays.stream(racingCar)
                .filter(car -> car.getPosition() == winnerPosition)
                .map(RacingCar::getCarName)
                .forEach(winnerName::add);
        }
    }

