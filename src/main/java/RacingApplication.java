import service.RacingCarService;
import view.InputView;

public class RacingApplication {
    public static void main(String[] args) {
        final String[] carNames = InputView.getCarNames();
        final int times = InputView.getTimes();

        RacingCarService racingCarService= new RacingCarService();
        racingCarService.play(carNames, times);
    }
}
