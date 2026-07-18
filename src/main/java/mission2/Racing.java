package mission2;

import mission1.RacingCar;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Racing {
    private final Random random;
    private final List<RacingCar> racingCarList;
    private final int gameCount;

    public Racing(String[] player, int gameCount){
        this.gameCount = gameCount;
        this.random = new Random();
        this.racingCarList = new LinkedList<>();
        init(player);
    }

    private void init(String[] player){
        for (String s : player) {
            racingCarList.add(new RacingCar(s));
        }
    }

    public void start(){
        for(int i = 0; i < gameCount; i++){
            roundResult();
        }
        getWinner();
    }


    private void move(){
        for(int i = 0; i < racingCarList.size(); i++){
            racingCarList.get(i).tryAdvance(random.nextInt(10));
        }
    }


    private void roundResult(){
        move();
        for(int i = 0; i < racingCarList.size(); i++){
            System.out.println(racingCarList.get(i).getName() + " : " + playerMoveRes(i));
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
        return sb.substring(0,sb.toString().length()-2);
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
