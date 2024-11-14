package view;

import java.util.List;

public class Result {

    // 실행 결과 문구
    public static void printResultLetter(){
      System.out.println("\n실행결과");
    }

    // 자동차 상태 출력
    public static void printCarDistance(String name, int distance){
        System.out.print(name + " : ");
        for (int i = 0; i < distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // 최종 우승 자동차 출력
    public static void printWinner(List<String> winners){
        for (int i = 0; i < winners.size(); i++){
            if (i == winners.size() - 1){
                System.out.print(winners.get(i));
                continue;
            }
            System.out.print(winners.get(i) + ", ");
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
