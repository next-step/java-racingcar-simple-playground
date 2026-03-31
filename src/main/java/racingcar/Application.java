package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Application {
    static Input input = new Input();
    static Output output = new Output();
    static CarGame carGame = new CarGame();
    static Random random = new Random();
    static NumberGenerator randomGen = () -> random.nextInt(10);

    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<String> names = input.inputName();
        System.out.println("시도할 회수는 몇회인가요?");
        int times = input.inputTimes();

        System.out.println("\n실행 결과");
        carGame.createCar(names);

        for (int i = 0; i < times; i++) {
            carGame.racing(Collections.nCopies(names.size(), randomGen));
            output.showDistance(carGame.cars);
        }

        output.showWinner(carGame.winner());
    }
}