import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class carMoveTest {
    private static IntStream provideRandomNumbers() {
        Random random = new Random();
        return random.ints(10, 0, 10); // 10개의 0부터 9까지의 랜덤 숫자를 생성합니다.
    }

    //    @ParameterizedTest
//    @MethodSource("provideRandomNumbers")
    @ParameterizedTest
    @ValueSource(ints = {3, 4})
    @DisplayName("random 값이 4 이상일 경우 전진")
    void carMoveForward(int value) {
        //given
        Car car = new Car();
        MoveCar moveCar = new MoveCar();

        int location = car.getCurrentLocation();

        // when
        //1 추가
        int current_location = moveCar.check(value, car);

        // 전진했으면 통과
        //then
        Assertions.assertThat(current_location).isEqualTo(location + 1);

    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4})
    @DisplayName("random 값이 3 이하의 값이면 멈춘다")
    void carStop(int value) {
        //given
        Car car = new Car();
        MoveCar moveCar = new MoveCar();
        int location = car.getCurrentLocation();


        //when
        int current_location = moveCar.check(value, car);

        // 그대로면 통과
        //then
        Assertions.assertThat(current_location).isEqualTo(location);

    }

/*    @Test
    void checkRace() {

        Car car = new Car();
        MoveCar moveCar = new MoveCar();
        Race race = new Race();

        int carCount = 12;
        int timeCount = 10;

        Car[] raceResult = race.startRace(race.initCar(carCount), carCount);

        *//*for (int i = 0; i < raceResult.length; i++) {
            System.out.println("result: " + raceResult[i].getCurrentLocation());
        }*//*

        *//*System.out.println("=======================================================");*//*
        ArrayList<Car> winners = race.getWinner(raceResult);

        *//*for (int i = 0; i < winners.size(); i++) {
            System.out.println(+winners.get(i).getCurrentLocation());
        }*//*

        // 우승자의 값이 1이 맞는지 확인
        for (int i = 0; i < winners.size(); i++){
            Assertions.assertThat(winners.get(i).getCurrentLocation()).isEqualTo(1);
        }
    }*/
}