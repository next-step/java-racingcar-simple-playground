import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

public class CarRacingGameApp {
    public static void main(String[] args) {
        List<String> carNames = getCarNames();
        int rounds = getRounds();

        CarRacingGame game = new CarRacingGame(carNames, rounds);
        game.race();

        printWinners(game.getWinners());
    }

//    자동차 이름 추출
    private static List<String> getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        // 쉼표를 기준으로 이름 추출
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());
    }

//    라운드 횟수 추출
    private static int getRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

//    CarRacingGame 클래스로부터 받아온 우승자 명단을 출력
    private static void printWinners(List<Car> winnerList) {
        String winnerNames = winnerList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
