import domain.*;
import view.InputView;
import view.ResultView;

import java.util.List;

public class Application {
    public static void main(String[] args)  {

        try {
            // 처음에 이것을 String[]으로 받고 CarName으로 걸러지는 과정을 RaceGame 생성시로 만들었는데 입력 받자마자 오류 뜨는게 맞는거 같아서 여기로 옮김
            // 아예 여기서 Car를 만들어 버리는 것이 맞을까?
            List<CarName> carNames = InputView.getCarsName();
            int tryCount = InputView.getTryCount();

            Cars cars = Cars.from(carNames);
            final RaceGame raceGame = new RaceGame(cars, tryCount, new RandomValueRule());

            raceGame.start();


            ResultView.printWinners(raceGame.getWinners());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
