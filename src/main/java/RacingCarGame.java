import controller.RacingCarController;
import dao.RacingCarDao;
import service.RacingCarService;
import service.RacingCarServiceImpl;
import util.NumberGenerateUtil;
import view.RacingCarView;

public class RacingCarGame {
  public static void main(String[] args) {
    RacingCarView racingCarView = new RacingCarView();
    RacingCarDao racingCarDao = new RacingCarDao();
    NumberGenerateUtil numberGenerateUtil = new NumberGenerateUtil();
    RacingCarService racingCarService = new RacingCarServiceImpl(racingCarDao, numberGenerateUtil);
    RacingCarController game = new RacingCarController(racingCarView, racingCarService);

    game.set();
    game.run();
  }
}
