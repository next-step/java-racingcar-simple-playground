import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        View view = new View(new Scanner(System.in));
        GameController gameController = new GameController(view);
        gameController.run();
    }
}
