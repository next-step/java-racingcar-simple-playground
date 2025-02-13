public class Main {
    public static void main(String[] args) {
        CarRace cr = new CarRace();

        cr.receiveCarNamesInput();
        cr.recieveCarRaceAttemptCountInput();
        cr.makeCarObject(cr.carNames.size());
        cr.doRace(cr.raceAttemptCount);
        cr.setWinnerCarNames();
        cr.printWinnerCarNames();
    }

}
