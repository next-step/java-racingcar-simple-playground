import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class InputView {
    public List<String> getCarName() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("5자 이하의 이름을 입력하세요. 이름은 쉼표로 구분됩니다.");
        String carName = scanner.nextLine();
        String[] names = carName.split(",");
        return Arrays.asList(names);
    }

    public int getTryCount() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("반복할 라운드 횟수를 입력하세요.");
        String input = scanner.nextLine();
        return Integer.parseInt(input);
    }
}
