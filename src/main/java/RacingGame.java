import java.util.List;
import java.util.Scanner;

public class RacingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameInput inputHandler = new GameInput(scanner);

        // 입력
        List<String> names = inputHandler.readCarNames();
        int roundCount = inputHandler.readRoundCount();


        // Car 객체 생성
        MoveCondition moveCondition = new MoveConditionImpl();
        List<Car> carList = names.stream()
                .map(name -> new Car(name, moveCondition))  // move 조건 정의
                .toList();

        Cars cars = new Cars(carList);

        // 실행 결과 출력
        GameOutput.printStart();
        for (int i = 0; i < roundCount; i++) {
            cars.moveAllOneRound(); // 1회씩 이동
            GameOutput.printRound(cars);
        }

        // 우승자 출력
        RaceJudge result = new RaceJudge(cars);
        GameOutput.printWinners(result.getWinnerNames());

    }
}

