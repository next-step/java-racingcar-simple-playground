package view;

import java.util.List;

public class OutputView {
    public void printInputCarsName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printInputGameRounds(){
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printGameResult(String gameResult){
        System.out.println(gameResult);
    }

    // TODO: 우승자 출력 구현해야함
    public void printWinnerCarNames(List<String> carNames){
        System.out.println("");
    }
}
