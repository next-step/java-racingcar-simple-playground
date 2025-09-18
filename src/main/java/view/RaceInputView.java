package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RaceInputView {

    public List<String> getCarNames() {
        Scanner scanner = new Scanner(System.in);
        String carNameInput = scanner.nextLine();

        List<String> carNames = Arrays.asList(carNameInput.split(","));
        return carNames;
    }

    public int getRaceTurnNumber() {
        Scanner scanner = new Scanner(System.in);
        int raceTurnNumber = scanner.nextInt();

        return raceTurnNumber;
    }
}
