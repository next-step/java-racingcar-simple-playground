import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();

        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String input = scanner.nextLine();

        try {
            race.makeCar(parseCarNames(input));

            System.out.println("시도할 회수는 몇회인가요?");
            int rounds = scanner.nextInt();

            System.out.println("\n실행 결과");

            race.moveCar(rounds);


            List<Car> cars = race.findWinners();

            for(int i=0; i < cars.size(); i ++){
                if(i != 0){
                    System.out.print(", ");
                }
                System.out.print(cars.get(i).getName());
            }
            System.out.println("가 최종 우승했습니다.");

        } catch (IllegalArgumentException e) {
            System.out.println("입력 오류: " + e.getMessage());
        }
    }

    public static String[] parseCarNames(String input) {
        String[] names = input.split(",");

        for (String name : names) {
            name = name.trim();
            if (name.isEmpty() || name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하여야 합니다: " + name);
            }
        }

        return names;
    }
}
