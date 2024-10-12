package view;

import Model.Car;
import java.util.List;

public class OutputView {

  private final String ROUND_RESULT_INFO_MESSAGE = "실행결과";
  private final String WINNER_RESULT_MESSAGE = "가 최종 우승했습니다.";

  private void print(String string) {
    System.out.println(string);
  }

  public void printRoundResultInfo() {
    print(ROUND_RESULT_INFO_MESSAGE);
  }
  public void printRoundResult(List<Car> CarList) {
    for (Car car : CarList) {
      String Result = car.getName() + " : " + posBar( car.getPos() );
      print(Result);
    }
    print("");
  }

  private String posBar(int pos) {
    String str = "";
    for (int i=0; i<pos; i++) {
      str += "-";
    }
    return str;
  }

  public void printWinner(List<String> winnerList) {
    String str = "";

    str += winnerList.get(0);

    for (int i=1; i<winnerList.size(); i++) {
      str += ", " + winnerList.get(i);
    }

    str += WINNER_RESULT_MESSAGE;
    print(str);
  }

}
