package view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import util.Errors;

public class InputView {

    private static final String NAMES_SEPARATOR = ",";

    private String getUserStringInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private int getUserIntegerInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public List<String> getParticipantNames() {
        String userInput = getUserStringInput();
        return Arrays.asList(userInput.split(NAMES_SEPARATOR));
    }

    public int getTryCount() {
       try {
           return getUserIntegerInput();
       }  catch (InputMismatchException e) {
           throw new IllegalArgumentException(Errors.INPUT_IS_NOT_INTEGER);
       }
    }
}
