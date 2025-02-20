package view;

public class ResultView {
    public static void printWinners(String[] winners) {
        System.out.println();
        System.out.println("실행 결과");
        String winnersForPrint = String.join(",", winners) + "가 최종우승하였습니다.";
        System.out.println(winnersForPrint);
    }
}
