package racingcar.controller.console;


import java.util.Scanner;
import racingcar.view.text.PromptHandler;


public class ConsolePromptHandler implements PromptHandler {

    private final Scanner input = new Scanner(System.in);

    @Override
    public String prompt(String message) {
        System.out.println(message);
        return input.nextLine();
    }

}
