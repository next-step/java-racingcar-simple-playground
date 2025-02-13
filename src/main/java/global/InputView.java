package global;

import java.util.Scanner;

public class InputView implements AutoCloseable {
    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public String readLine(String prompt){
        System.out.println(prompt);

        return scanner.nextLine();
    }

    public int readInt(String prompt){
        System.out.println(prompt);

        return scanner.nextInt();
    }

    @Override
    public void close(){
        scanner.close();
    }
}
