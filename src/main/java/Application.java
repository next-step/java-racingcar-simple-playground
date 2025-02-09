import domain.Race;
import view.InputView;
import view.ResultView;

public class Application {

    private static Race race;
    private static int round;
    public static void main(String[] args) {
        while(true){
            if (getValiedNames()) break; //5글자를 넘는 이름을 입력받는 경우 재시도
        }
        round = InputView.getTryCount();
        runRace();
        ResultView.printWinners(race.getWinner());
    }

    private static boolean getValiedNames() {
        try{
            race = new Race(InputView.getCarNames());
            return true;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

    private static void runRace(){
        System.out.println("domain.Race result");
        race.runRace(round);
    }
}
