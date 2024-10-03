package controller;

import domain.Cars;
import domain.WinnerSelector;
import view.View;

public class Game {

    public void startGame() {
        try {
            String inputNames = View.inputCarName();
            int tryCount = View.inputTryCount();

            Cars cars = new Cars();

            //입력 받은 자동차 이름 분리 및 자동차 생성
            cars.splitCarName(inputNames);
            cars.generateCar();

            //게임 시작 및 게임 과정 출력
            Game(cars, tryCount);

            //우승자 출력
            WinnerSelector winnerSelector = new WinnerSelector();
            View.printWinner(winnerSelector.getWinners(cars.getCars()));

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }
    //생성자를 통해 게임 시작
    public void Game(Cars cars, int tryCount){
        for(int i = 0; i<tryCount; i++){
            cars.moveCars();
            View.printRacingGame(cars.getCars());
        }
    }
}
