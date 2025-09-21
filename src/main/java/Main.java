import controller.RaceController;
import utils.RandomDigitGenerator;
import view.RaceInputView;
import view.RaceOutputView;

public class Main {
    public static void main(String[] args) {
        new RaceController(new RaceInputView(), new RaceOutputView(), new RandomDigitGenerator())
                .runRace();
    }
}
