package view;

import exception.InvalidNameInputException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VehicleRaceNameInput {

    public static List<String> getNames(Scanner scanner){
        List<String> names = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String userInput = scanner.nextLine();

        return Arrays.stream(userInput.split(",")).toList();
    }

    public static void validateNames(List<String> names) {
        for(String name : names){
            if (!name.matches(".{1,5}")) {
                throw new InvalidNameInputException("Name should have 5 or less characters.");
            }
        }
    }
}
