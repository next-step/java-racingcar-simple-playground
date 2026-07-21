package mission4.view;

import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printRoundResult(List<Map<String, Integer>> roundResult){
        System.out.println("실행결과");
        for(Map<String, Integer> round : roundResult){
            System.out.println(toRoundLine(round));
        }
    }

    private static String toRoundLine(Map<String, Integer> round){
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<String, Integer> entry : round.entrySet()){
            sb.append(entry.getKey()).append(" : ").append("-".repeat(entry.getValue())).append("/n");
        }
        return sb.toString();
    }

    public static void printWinner(List<String> winners){
        System.out.println(String.join(",", winners)+ "가 우승했습니다.");
    }
}
