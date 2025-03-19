import controller.CarRunner;
import domain.NumberGenerator;
import domain.RandomNumberGenerator;
import java.util.Scanner;
import view.InputView;
import view.OutputView;

public class Application {

  public static void main(String[] args) {
    InputView inputView = new InputView(new Scanner(System.in));
    OutputView outputView = new OutputView();
    NumberGenerator numberGenerator = new RandomNumberGenerator();
    CarRunner carRunner = new CarRunner(inputView, outputView, numberGenerator);
    carRunner.run();
  }
}

