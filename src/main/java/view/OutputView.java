package view;

import domain.RacingCar;
import java.util.List;

public class OutputView {

    private static final String GRAPH_SYMBOL = "-";

    public static void printEachRace(List<RacingCar> cars){
        System.out.println("실행 결과");
        for(RacingCar car : cars){
            System.out.println(car.getName() + " : " + getPositionGraph(car.getPosition()));
        }
        System.out.println();
    }

    private static String getPositionGraph(int position){
        return GRAPH_SYMBOL.repeat(position);
    }

    public static void printFinalResult(List<String> names){
        StringBuilder sb = new StringBuilder();
        for(String name : names){
            sb.append(name).append(", ");
        }
        sb.delete(sb.length()-2, sb.length());
        System.out.println(sb.toString() + "가 최종 우승했습니다.");
    }
}
