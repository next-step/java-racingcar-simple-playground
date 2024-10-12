package view;

import dto.RacingCarResultDto;
import java.lang.module.ResolutionException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;


public class RacingCarView {
  public static class RacingCarInputException extends RuntimeException {

    public RacingCarInputException() {
      super("유효하지 않은 입력입니다.");
    }

    public RacingCarInputException(final String s) {
      super(s);
    }
  }

  public List<String> inputRacingCarName() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    String input = scanner.nextLine().replaceAll(" ", "");

    if (Pattern.compile("[!@#$%^&*().?\"{}|<>]").matcher(input).find())
      throw new RacingCarInputException("이름에 특수기호를 입력할 수 없습니다.");

    List<String> names = List.of(input.split(","));

    if (names.size() <= 1)
      throw new RacingCarInputException("최소한 두 명 이상의 플레이어가 필요합니다.");


    return names;
  }

  public int inputRound() {
    Scanner scanner = new Scanner(System.in);

    System.out.println("시도할 회수는 몇회인가요?");

    try {
      int round = scanner.nextInt();

      if (round <= 0)
        throw new NumberFormatException("횟수는 1회 이상이여야 합니다.");

      return round;
    } catch (InputMismatchException e) {
        throw new RacingCarInputException();
    } catch (NumberFormatException e) {
      throw new RacingCarInputException(e.getMessage());
    }
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
