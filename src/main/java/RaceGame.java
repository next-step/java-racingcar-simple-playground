import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RaceGame implements Game {

    private final List<Car> participants;
    private int count;

    private int maxLength;

    public RaceGame() {
        this.participants = new ArrayList<>();
        this.maxLength = 0;
        this.count = 0;
    }

    public void preparing() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");

        // 이것이 여기 있어야 할까
        Scanner sc = new Scanner(System.in);

        String[] carNames = sc.nextLine().split(",");
        for (String carName : carNames) {
            participants.add(new Car(carName));
        }


        System.out.println("시도할 회수는 몇회인가요?");
        this.count = sc.nextInt();
    }
    public void start() {

        // Random class를 확장 함수르 만들어 버리고 싶음
        Random rd = new Random();

        for (int i = 0; i < count; i++) {
            for (Car participant: participants) {
                if (rd.nextInt(10) >= 4) {
                    participant.move();

                    if (participant.location > maxLength) {
                        maxLength = participant.location;
                    }
                }
            }

            for (Car participant: participants) {
                String position = "-".repeat(participant.location);
                System.out.println(participant.name + " : " + position);
            }
            System.out.println();
        }
    }

    public void end() {
        List<Car> winners = findWinners();

        String carNames = "";
        for (int i = 0; i < winners.size(); i++) {
            carNames += winners.get(i).name;

            if (i != winners.size() - 1) {
                carNames += ", ";
            }
        }

        System.out.println(carNames + "가 최종 우승했습니다");
    }

    private List<Car> findWinners() {
        List<Car> winners = new ArrayList<Car>();

        for(Car participant: participants) {
            if (maxLength == participant.location) {
                winners.add(participant);
            }
        }

        return winners;
    }
}
