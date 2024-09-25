import domain.Cars;
import controller.Game;
import domain.WinnerSelector;
import view.View;

public class Main {
    public static void main(String[] args) {
        final String inputNames = View.inputCarName();;
        final int tryCount = View.inputTryCount();

        try {
            //입력 받은 자동차 이름 분리
            Cars.splitCarName(inputNames);
            //자동차 생성 및 자동차 이름 부여
            Cars.generateCar();
            //게임 시작 및 게임 과정 출력
            Game racingame = new Game(tryCount);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
        //게임 결과 우승자 출력
        View.printWinner(WinnerSelector.getWinners(Cars.cars));
    }
}
