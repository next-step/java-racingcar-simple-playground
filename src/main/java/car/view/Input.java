package car.view;

import java.util.Scanner;

public class Input {
    Scanner scanner = new Scanner(System.in);

    public String inputCarName(){
        System.out.println(Constant.RACING_CAR_NAMES);
        return scanner.next();
    }
    public String inputGameNumber(){
        System.out.println(Constant.TRY_COUNT);
        return scanner.next();
    }
}
