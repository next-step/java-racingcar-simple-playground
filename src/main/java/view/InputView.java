package view;

import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);

    public static String getCarNames(){
        System.out.println("Enter names of cars which join the race (Names are separated by commas)");
        return scanner.nextLine();
    }

    public static int getTryCount(){
        System.out.println("Enter rounds of race");
        return scanner.nextInt();
    }

}
