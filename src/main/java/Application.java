import controller.RacingGameController;

public class Application {
    public static void main(String[] args) {
        try {
            new RacingGameController().run();
        } catch(Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
