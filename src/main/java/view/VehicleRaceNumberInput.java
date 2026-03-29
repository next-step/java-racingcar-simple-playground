package view;

import exception.InvalidNumberInputException;

import java.util.Scanner;

public class VehicleRaceNumberInput {
    public static int getNumber(Scanner scanner) {
        System.out.println("시도할 회수는 몇회인가요?");
        String userInput = scanner.nextLine();

        if (!userInput.matches("\\d")) {
            throw new InvalidNumberInputException("Not a Number");
        }

        return Integer.parseInt(userInput);
    }
}
