package global;

public class ResultView {
    public static void printWinners(String[] winners){
        String winnersForPrint = String.join(",", winners) +"가 최종우승하였습니다.";
        System.out.println(winnersForPrint);
    }
}
