package view;

import dto.RacingCarResultDto;
import java.util.List;
import java.util.Scanner;

public class RacingCarView {

  public List<String> inputRacingCarName() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    String input = scanner.nextLine();

    return List.of(input.split(","));
  }

  public int inputRound() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("시도할 회수는 몇회인가요?");
    int round = scanner.nextInt();

    return round;
  }

  public void printResultTitle() {
    System.out.println("\n실행 결과");
  }

  public void printResult(List<RacingCarResultDto> racingCarResultDtoList) {
    for (RacingCarResultDto racingCarResultDto : racingCarResultDtoList) {
      System.out.printf("%s : %s%n", racingCarResultDto.getName(), racingCarResultDto.getResultString());
    }
    System.out.println();
  }

  public void printWinner(List<RacingCarResultDto> racingCarResultDtoList) {
    int maxDistance = racingCarResultDtoList.stream().mapToInt(RacingCarResultDto::getDistance).max().orElseThrow();

    List<String> winners = racingCarResultDtoList.stream().filter(v -> v.getDistance() == maxDistance).map(RacingCarResultDto::getName).toList();

    System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
  }
}
