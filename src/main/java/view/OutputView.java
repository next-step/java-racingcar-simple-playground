package view;

import Dto.GameResultDto;
import Dto.RoundResultDto;
import model.Car;
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
  public void printRoundResult(List<RoundResultDto> results) {
    for (RoundResultDto result : results) {
      String Result = result.getName() + " : " + posBar( result.getPos() );
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

  public void printWinner(GameResultDto result) {

    List<String> winnerList =  result.getNameList();
    String str = "";

    str += winnerList.get(0);

    for (int i=1; i<winnerList.size(); i++) {
      str += ", " + winnerList.get(i);
    }

    str += WINNER_RESULT_MESSAGE;
    print(str);
  }

}
