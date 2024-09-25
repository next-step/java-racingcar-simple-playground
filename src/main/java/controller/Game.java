package controller;

import domain.Cars;
import view.View;

public class Game {
    public Game(int tryCount){
        checkNum(tryCount);
        for(int i = 0; i<tryCount; i++){
            Cars.moveCars();
            View.printRacingGame(Cars.cars);
        }
    }

    private static void checkNum(int tryCount){
        if(tryCount<1){
            throw new IllegalArgumentException("시도 횟수는 자연수만 가능합니다.");
        }
    }
}
