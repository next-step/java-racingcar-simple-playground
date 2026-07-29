package domain;

public class RacingGame {

    private final Cars cars;

    public RacingGame(String[] carNames, MoveRule moveRule){
        cars = new Cars(carNames, moveRule);
    }


    public int[] eachRound(){ // 위치 랜덤
        return cars.moveAll();
    }


    public String[] getWinners(){
        return cars.getWinners();
    }
}
