package mission2;

import mission1.RacingCar;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Racing {
    private final Random random;
    private final String[] player;
    private final List<RacingCar> racingCarList;
    private final int gameCount;

    public Racing(String[] player, int gameCount){
        this.player = player;
        this.gameCount = gameCount;
        this.random = new Random();
        this.racingCarList = new LinkedList<>();
        init();
    }

    private void init(){
        for(int i = 0; i < player.length; i++){
            racingCarList.add(new RacingCar(player[i]));
        }
    }

    public void start(){
        for(int i = 0; i < gameCount; i++){
            roundResult();
        }
        getWinner();
    }


    private void move(){
        for(int i = 0; i < player.length; i++){
            racingCarList.get(i).moveAndStop(random.nextInt(10));
        }
    }


    private void roundResult(){
        move();
        for(int i = 0; i < player.length; i++){
            System.out.println(player[i] + " : " + playerMoveRes(i));
        }
        System.out.println();
    }

    private String playerMoveRes(int index){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < racingCarList.get(index).getDistance(); i++){
            sb.append("-");
        }
        return sb.toString();
    }

    private int maxDistance(){
        int max = racingCarList.get(0).getDistance();
        for(int i = 1; i < racingCarList.size(); i++){
            max = Math.max(max, racingCarList.get(i).getDistance());
        }
        return max;
    }

    private String compareMoveDistance(){
        StringBuilder sb = new StringBuilder();
        int max = maxDistance();
        for(int i = 0; i < racingCarList.size(); i++){
            sb.append(winner(i, max));
        }
        return sb.toString().substring(0,sb.toString().length()-2);
    }

    private String winner(int i, int max){
        if(racingCarList.get(i).getDistance() == max){
            return racingCarList.get(i).getName() + ", ";
        }
        return "";
    }

    private void getWinner(){
        System.out.println(compareMoveDistance() + "가 우승했습니다");
    }
}
