import java.util.List;
import java.util.Scanner;

public class GameView {
    static Scanner in = new Scanner(System.in);

    public String inputCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String carName = in.nextLine();
        if(carName == null || carName.isEmpty()) throw new RuntimeException("자동차 이름을 제대로 입력해주세요.");
        return carName;
    }

    public int inputRunCount(){
        System.out.println("시도할 횟수는 몇 회인가요?");
        int runCount;
        try{
            runCount = in.nextInt();
            runCountMinusCheck(runCount);
        }
        catch (NumberFormatException e) {
            throw new RuntimeException("정수만 가능합니다.");
        }
        return runCount;
    }

    private void runCountMinusCheck(int runCount){
        if(runCount <= 0) throw new RuntimeException("실행횟수가 0이하 입니다.");
    }

    public void printGameStart() {
        System.out.println("\n실행 결과");
    }

    public void printRound(List<RacingCar> racingCars) {
        for (RacingCar car : racingCars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getForwardCount()));
        }
        System.out.println();
    }

    public void printWinner(List<String> winnerCars){
        System.out.println("최종 우승자 : " + String.join(", ", winnerCars));
    }
}
