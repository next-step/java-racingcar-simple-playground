import java.util.ArrayList;

public class GameResult {
    private Car[] cars; //참가한 자동차들
    private int winnerPosition; //우승 자동차의 위치(최대값)
    private int winnerCnt; //우승 자동차의 수
    private ArrayList<String> winnerNames; //우승 자동차의 이름

    public GameResult(Car[] cars) {
        this.cars = cars;
        winnerCnt = 0;
        winnerPosition = Integer.MIN_VALUE;
        winnerNames = new ArrayList<>();
    }

    public int getWinnerCnt() {
        return winnerCnt;
    }

    public int getWinnerPosition() {
        return winnerPosition;
    }

    public ArrayList<String> getWinnerName() {
        return winnerNames;
    }

    public void whichWinner(int testRounds){
        //1. 모든 자동차를 주어진 횟수만큼 이동
        moveAllCars(testRounds);
        //2. 우승자의 수와 자동차의 위치(최대값) 계산
        countWinners();
        //3. 우승자 이름 저장
        saveWinnerName();
    }

    //1. 모든 자동차를 주어진 횟수만큼 이동
    private void moveAllCars(int testRounds){
        for (Car car : cars) {
            for (int i = 0; i < testRounds; i++) {
                car.move(RandomUtil.randomGenerator());
            }
        }
    }

    //2. 우승자의 수와 자동차의 위치(최대값) 계산
    private void countWinners(){
        for (Car car : cars) {
            updateWinnerCount(car);
        }
    }

    //2-1. 자동차 한 대씩 우승자의 수와 최고 위치 갱신
    private void updateWinnerCount(Car car) {
        int position = car.getPosition();
        if (position > winnerPosition) {
            winnerCnt = 1;
            winnerPosition = position;
            return;
        }
        if (position == winnerPosition) {
            winnerCnt++;
        }
    }

    //3. 우승자 이름 저장
    private void saveWinnerName(){
        for (Car car : cars) {
            if (car.getPosition() == winnerPosition) {
                winnerNames.add(car.getName());
            }
        }
    }
}


