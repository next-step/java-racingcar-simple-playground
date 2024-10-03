import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RacingCarGame {

  int highScore;
  int phase = 0;
  List<RacingCar> racingCars = new ArrayList<>();
  boolean isGameInit = false;

  public void setGame() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    String input = scanner.nextLine();

    for (String name : input.split(","))
      racingCars.add(new RacingCar(name));

    if (racingCars.size() < 2)
      throw new InputMismatchException("최소한 두 명 이상의 플레이어가 필요합니다.");

    System.out.println("시도할 회수는 몇회인가요?");
    try {
      phase = scanner.nextInt();
      if (phase < 0) {
        throw new NumberFormatException("음수는 유효한 숫자가 아닙니다.");
      }
    } catch (InputMismatchException e) {
      throw new InputMismatchException("유효한 숫자가 아닙니다.");
    }


    isGameInit = true;
  }

  public void startGame() {
    if (!isGameInit)
      throw new IllegalStateException("게임이 초기화되지 않았습니다.");

    for(int i = 0; i < phase; ++i){
      moveAllRacingCars();
    }

    printResult();
  }

  public void resetGame() {
    racingCars.clear();
    highScore = 0;
  }

  private void moveAllRacingCars() {
    for(RacingCar racingCar : racingCars)
      racingCar.move();
  }

  private void printResult() {
    System.out.println("\n실행 결과");

    for (int i = 1; i <= phase; ++i){
      printAllRacingCarResults(i);
      System.out.println();
    }

    System.out.println(String.join(", ", getWinnerNames()) + "가 최종 우승했습니다.");
  }

  private void printAllRacingCarResults(int phase) {
    for (RacingCar racingCar : racingCars) {
      System.out.println(racingCar.getName() + " : " + racingCar.getResultString(phase));
    }
  }

  private List<String> getWinnerNames() {
    return racingCars.stream().filter(this::checkWinner).map(RacingCar::getName).toList();
  }

  private boolean checkWinner(RacingCar racingCar) {
    if (racingCar.getScore() > highScore)
      highScore = racingCar.getScore();

    return racingCar.getScore() == highScore;
  }
}
