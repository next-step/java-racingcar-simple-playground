import domain.Car;
import domain.Race;
import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.stream.Stream;

public class RaceTest {

    Car[] raceList() {
        Race race = new Race();

        String nameString = "one,two,three";

        String[] names = race.sepNames(nameString);

        Car[] carList = race.initCar(3, names);
        carList[0].setCurrentLocation(5);
        carList[1].setCurrentLocation(2);
        carList[2].setCurrentLocation(3);

        return carList;
    }

    @ParameterizedTest
    @ValueSource(strings = {"일이삼", "일이삼사오육"})
    @DisplayName("문자열 길이 확인")
    void nameLengthTest(String value) {
        Race race = new Race();

        try {
            race.checkNameLength(value);
        } catch (Exception e) {
            System.out.printf(e.getMessage());
            Assertions.fail("문자열의 길이가 5 이상 입니다.");
        }
    }

    @Test
    @DisplayName("문자열 분리 확인")
    void sepNamesTest() {
        Race race = new Race();

        String nameString = "one,two,three";

        String[] names = race.sepNames(nameString);

        Assertions.assertThat(names[0]).isEqualTo("one");
        Assertions.assertThat(names[1]).isEqualTo("two");
        Assertions.assertThat(names[2]).isEqualTo("three");
    }

    @Test
    @DisplayName("n개의 자동차 생성 확인")
    void initCarTest() {
        Race race = new Race();

        String nameString = "one,two,three";

        String[] names = race.sepNames(nameString);

        Car[] carList = race.initCar(3, names);

        for (int i = 0; i < 3; i++) {
            Assertions.assertThat(carList[i].getName()).isEqualTo(names[i]);
            Assertions.assertThat(carList[i].getCurrentLocation()).isEqualTo(0);

        }
    }

    @Test
    @DisplayName("race 동작 확인")
    void startRaceTest() {
        Race race = new Race();

        String nameString = "one,two,three";

        String[] names = race.sepNames(nameString);

        Car[] carList = race.initCar(3, names);

        Car[] raceResult = race.startRace(carList, 3);

        for (int i = 0; i < 3; i++) {
            Assertions.assertThat(carList[i].getName()).isEqualTo(names[i]);
            Assertions.assertThat(carList[i].getCurrentLocation()).isBetween(0, 1);
        }
    }

    @Test
    @DisplayName("최대 숫자 구하는 동작 확인")
    void getMaxNumberTest() {
        Race race = new Race();

        Car[] carList = raceList();

        int max = carList[0].getCurrentLocation();
        int index = 0;
        for (int i = 0; i < carList.length; i++) {
            index = race.getMaxNumber(carList[i], max, index, i);
        }
        Assertions.assertThat(carList[index].getCurrentLocation()).isEqualTo(5);
    }

    @Test
    @DisplayName("우승자 구하기")
    void getWinnerTest() {
        Race race = new Race();

        Car[] carList = raceList();
        ArrayList<Car> raceResult = race.getWinner(carList);

        for (int i = 0; i < raceResult.size(); i++) {
            Assertions.assertThat(carList[i].getCurrentLocation()).isEqualTo(5);
        }
    }

    @Test
    @DisplayName("중복 우승자 구하기")
    void checkWinnersInArrayTest() {
        Race race = new Race();

        Car[] carList = raceList();
        carList[1].setCurrentLocation(5);

        ArrayList<Car> winners = new ArrayList<>();

        for (int i = 0; i < carList.length; i++) {
            race.checkWinnersInArray(carList, winners, 5, i);
        }

        Assertions.assertThat(winners.size()).isEqualTo(2);
        Assertions.assertThat(winners.get(0).getCurrentLocation()).isEqualTo(5);

    }

    @Test
    @DisplayName("우승자 중 중복 체크")
    void checkDuplication() {
        Race race = new Race();

        Car[] carList = raceList();
        carList[1].setCurrentLocation(5);

        int result = race.checkDuplication(carList, 5, 1);

        Assertions.assertThat(result).isEqualTo(1);
    }
}
