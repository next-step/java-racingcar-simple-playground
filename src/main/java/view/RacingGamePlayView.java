package view;

public class RacingGamePlayView implements RacingGameView {

    private static final String MOVE_INDICATOR = "-";

    public void printRaceResultHeader() {
        System.out.println("실행 결과");
    }

    public void printCarInformation(String carName, int moveDistance) {
        String formattedCarInformation = formatCarInformation(carName, moveDistance);

        System.out.println(formattedCarInformation);
    }

    private String formatCarInformation(String carName, int moveDistance) {
        return carName + " : " + MOVE_INDICATOR.repeat(moveDistance);
    }

}
