import controller.CarController;
import utils.RandomValueGenerator;
import utils.ValueGenerator;

public class Application {

    public static void main(String[] args) {
        final ValueGenerator generator = new RandomValueGenerator();
        CarController controller = new CarController();
        controller.gameRun(generator);
    }

}
