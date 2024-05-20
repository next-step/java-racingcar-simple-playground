package view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import util.Constants;
import util.Errors;
import util.Validator;

public class InputView {

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
        List<String> names = Arrays.asList(userInput.split(Constants.NAMES_SEPARATOR));
        Validator.validateParticipantNames(names);
        return names;
    }

    public int getTryCount() {
       try {
           int tryCount = getUserIntegerInput();
           Validator.validateRangeOfTryCount(tryCount);
           return tryCount;
       }  catch (InputMismatchException e) {
           throw new IllegalArgumentException(Errors.INPUT_IS_NOT_INTEGER);
       }
    }
}
