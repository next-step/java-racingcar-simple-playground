package Controller;

import Domain.CarList;
import Domain.RacingCar;
import View.InputView;
import View.OutputView;

public class RacingCarMain {

    public static void main(String[] args){

        final var carNames = InputView.getCarName();
        final var tryCount= InputView.getTryCount();

        CarList carList=new CarList(carNames);
        RacingCar game=new RacingCar();

        OutputView outputView=new OutputView();

        for(int i=0;i<tryCount;i++){
            outputView.printCarNameOutput(carList);
            System.out.println();
        }

       OutputView.printWinners(game.findWinners(carList));
    }

}
