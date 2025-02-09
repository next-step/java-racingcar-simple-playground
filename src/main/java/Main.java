import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            List<RacingCar> cars = createCars(scanner);
            int rounds = getRoundsFromUser(scanner);

            Race race = new Race(cars);
            race.race(rounds);

            printResults(race);
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage()); // 오류 메세지 출력
        }
    }

    private static List<RacingCar> createCars(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분):");
        String input = scanner.nextLine();

        List<RacingCar> cars = new ArrayList<>();
        Random random = new Random();

        for (String name : input.split(",")) {
            String trimmedName = name.trim();
            verifyCarName(trimmedName); // 이름 유효성 검사
            cars.add(new RacingCar(trimmedName, random)); // 자동차 객체 생성 후 추가
        }
        return cars;
    }

    // 자동차 이름 유효성 검사
    private static void verifyCarName(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1~5자만 가능합니다.");
        }
    }

    private static int getRoundsFromUser(Scanner scanner) {
        System.out.println("시도할 횟수는 몇 회인가요?");
        while (!scanner.hasNextInt()) {
            System.out.println("숫자를 입력해야 합니다. 다시 입력하세요:");
            scanner.nextLine();
        }

        int rounds = scanner.nextInt();
        scanner.nextLine();

        if (rounds <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1 이상의 정수여야 합니다.");
        }

        return rounds;
    }

    private static void printResults(Race race) {
        System.out.println("\n 실행 결과:");
        printCarPositions(race.getCars());
        printWinners(race.findWinners());
    }

    private static void printCarPositions(List<RacingCar> cars) {
        for (RacingCar car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition())); // 위치만큼 '-' 출력
        }
    }

    private static void printWinners(List<RacingCar> winners) {
        System.out.print(String.join(", ", getWinnerNames(winners)));
        System.out.println("가 최종 우승했습니다.");
    }

    // 우승자의 이름 리스트 반환
    private static List<String> getWinnerNames(List<RacingCar> winners) {
        return winners.stream()
                .map(RacingCar::getName)
                .toList();
    }
}
