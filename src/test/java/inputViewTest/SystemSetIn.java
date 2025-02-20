package inputViewTest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class SystemSetIn {
    public static void inputStringTestStrat(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }

    public static void inputTestEnd() {
        System.setIn(System.in);
    }

    public static void inputIntTestStrat(int input) {
        String inputStr = String.valueOf(input) + "\n";
        InputStream inputStream = new ByteArrayInputStream(inputStr.getBytes());
        System.setIn(inputStream);
    }
}
