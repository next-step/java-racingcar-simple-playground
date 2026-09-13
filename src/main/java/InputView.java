import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class InputView {
    public List<String> getCarName() {
        Scanner scanner = new Scanner(System.in);
        String carName = scanner.nextLine();
        String[] names = carName.split(",");
        return Arrays.asList(names);
    }

    public int getTryCount() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
}
