package view;

import domain.Car;
import domain.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Scanner;
import domain.RacingGame;

public class InputView {
    private static final RacingGame racingGame = new RacingGame();
    private final Scanner scanner = new Scanner(System.in);

    public String[] getCarNames() {
        String[] carNamesArray = getValidateCarNames();
        return  carNamesArray;
    }

    private String[] getValidateCarNames() {
        while(true) {
            try{
                System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
                String carNames = scanner.nextLine();
                String[] carNamesArray = carNames.split(",");
                racingGame.validateCarNameInput(carNamesArray);

                return carNamesArray;
            } catch(final IllegalArgumentException e) {
                System.out.println("에러! :" + e.getMessage());
            }
        }
    }

    public int getValidateTryCount() {
        while(true) {
            try {
                System.out.println("시도할 횟수는 몇 회인가요?");
                int tryCount = scanner.nextInt();
                racingGame.validateTryCountInput(tryCount);

                return tryCount;
            } catch(final IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
