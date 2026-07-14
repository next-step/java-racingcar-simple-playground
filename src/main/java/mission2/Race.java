package mission2;

import mission1.RacingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    
    private int gameCount; // 레이싱 횟수
    private int playerCount; // 레이싱 참가 플레이어
    private RacingCar[] racingCars;
    private Random random;
    private List<String> winners;
    
    Race(int gameCount, int playerCount){
        this.gameCount = gameCount;
        this.playerCount = playerCount;
        racingCars = new RacingCar[playerCount];
        random = new Random();
        winners = new ArrayList<>();
    }

    private void racingInit(String[] names){
        for(int i = 0; i < playerCount; i++){
            racingCars[i] = new RacingCar(names[i]);
        }
    }
    
    private void racingStart(String[] names){
        racingInit(names);
        roundGame();
        winner();
    }

    private void winner() {
        int max = getMax();
        for(int i = 0; i < playerCount; i++){
            setWinners(max, i);
        }
    }

    private int getMax() {
        int max = racingCars[0].getDistance();
        for(int i = 1; i < playerCount; i++){
            max = Math.max(max, racingCars[i].getDistance());
        }
        return max;
    }

    private void roundGame() {
        for(int i = 0; i < gameCount; i++){
            moveAndStop();
        }
    }

    private void moveAndStop() {
        for(int j = 0; j < playerCount; j++){
            racingCars[j].moveAndStop(random.nextInt(10));
        }
    }

    private void setWinners(int max, int index) {
        if(max == racingCars[index].getDistance()){
            winners.add(racingCars[index].getName());
        }
    }
    
    public List<String> getWinners(String[] names){
        racingStart(names);
        return winners;
    }
}
