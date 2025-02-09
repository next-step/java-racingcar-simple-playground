import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Game {
    Competition game = new Competition();

    public void game(){
        String[] carNames = getCarNames();
        int gameTime = getGameTime();

        if(isVaildNames(carNames)){
            return;
        }

        joinGame(carNames);

        startGame(gameTime);

        gameWinnerPrint();
    }

    private String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        String value = scanner.nextLine();
        return value.split(",");
    }

    private int getGameTime() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private boolean isVaildNames(String[] cars){
        return Arrays.stream(cars).allMatch(car -> car.length() > 5);
    }

    private void joinGame(String[] cars){
        for (String car : cars){
            game.joinCompetition(car);
        }
    }

    private void startGame(int gameTime){
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < gameTime;i++){
            game.runCompetition();
            gamePrint();
            System.out.println();
        }
    }

    private void gamePrint(){
        for (Car car : game.cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    private void gamePrint2(){
        for (Car car : game.cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
    }

    private void gameWinnerPrint(){
        ArrayList<Car> winners = game.getWinners();
        StringJoiner joiner = new StringJoiner(", ");

        for (Car car : winners) {
            joiner.add(car.getName());
        }

        System.out.print(joiner.toString() + "가 최종 우승했습니다.");

    }
}