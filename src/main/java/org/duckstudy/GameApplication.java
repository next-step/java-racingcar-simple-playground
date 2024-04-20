package org.duckstudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.duckstudy.generator.Generator;
import org.duckstudy.generator.RandomValueGenerator;
import org.duckstudy.movingcar.Car;
import org.duckstudy.movingcar.Cars;
import org.duckstudy.validator.InputValidator;

public class GameApplication {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nameList = inputCarNames(br);
        int repetitionNum = inputRepetitionNum(br);

        Generator generator = new RandomValueGenerator();
        Cars cars = new Cars(nameList.length, nameList, generator);
        validateInput(nameList, repetitionNum, cars);
        printGameResult(cars, repetitionNum);
    }

    private static String[] inputCarNames(BufferedReader br) throws IOException {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분.");
        return br.readLine().split(",");
    }

    private static int inputRepetitionNum(BufferedReader br) throws IOException {
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(br.readLine());
    }

    private static Optional<InputValidator> validateInput(String[] nameList, int repetitionNum, Cars cars) {
        try {
            InputValidator inputValidator = new InputValidator(repetitionNum, nameList);
            return Optional.of(inputValidator);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return Optional.empty();
        }
    }

    private static void printGameResult(Cars cars, int repetitionNum) {
        System.out.println("\n실행 결과");
        List<Car> winnerList = cars.play(repetitionNum);
        String winnerNames = winnerList.stream().map(Car::getName).collect(Collectors.joining(", "));
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
