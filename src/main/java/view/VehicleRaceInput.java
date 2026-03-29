package view;

import exception.InvalidNameInputException;
import exception.InvalidNumberInputException;

import java.util.List;
import java.util.Scanner;

public class VehicleRaceInput {
    public List<String> getNamesInput() {
        Scanner scanner = new Scanner(System.in);
        List<String> names = VehicleRaceNameInput.getNames(scanner);

        try {
            VehicleRaceNameInput.validateNames(names);
        } catch (InvalidNameInputException e) {
            System.out.println(e.getMessage());
            return getNamesInput();
        }
        scanner.close();

        return names;
    }

    public int getNumberInput() {
        int number;
        Scanner scanner = new Scanner(System.in);

        try {
            number = VehicleRaceNumberInput.getNumber(scanner);
        } catch (InvalidNumberInputException e) {
            System.out.println(e.getMessage());
            return getNumberInput();
        }
        scanner.close();

        return number;
    }
}
