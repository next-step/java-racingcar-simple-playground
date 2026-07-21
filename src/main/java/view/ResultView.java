package view;

public class ResultView {

    public static void printWinners(String[] winners){
        for(int i = 0; i < winners.length - 1; i++){
            System.out.print(winners[i] + ", ");
        }
        System.out.println(winners[winners.length - 1] + "가 최종 우승했습니다.");
    }
}
