package controller;

import domain.Cars;
import view.View;

public class Game {

    //생성자를 통해 게임 시작
    public Game(Cars cars, int tryCount){
        checkNum(tryCount);
        for(int i = 0; i<tryCount; i++){
            cars.moveCars();
            View.printRacingGame(cars.getCars());
        }
    }

    private void checkNum(int tryCount){
        if(tryCount<1){
            throw new IllegalArgumentException("시도 횟수는 자연수만 가능합니다.");
        }
    }
}
