package view;

public class ResultView {

    public static void printWinners(String winners) {
        System.out.println("\n최종 우승자: " + winners);
    }

    public static void printCarPosition(String carName, int position) {
        System.out.println(carName + " : " + "-".repeat(position));
    }

    public static void printResultHeader() {
        System.out.println("\n실행 결과");
    }
}
