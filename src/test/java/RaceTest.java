import domain.Car;
import domain.Input;
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

    ArrayList<Car> raceList() {
        Race race = new Race();
        Input input = new Input();

        String nameString = "one,two,three";

        String[] names = input.separateNames(nameString);

        ArrayList<Car> carList = race.initCar(names);

        carList.get(0).severalForward(5);
        carList.get(1).severalForward(2);
        carList.get(2).severalForward(3);

        return carList;
    }

    @ParameterizedTest
    @ValueSource(strings = {"123456", " "})
    @DisplayName("문자열 길이 확인")
    void nameLengthTest(String value) {
        Input input = new Input();

        Assertions.assertThatThrownBy(() -> input.checkNameLength(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("문자열 분리 확인")
    void separateNamesTest() {
        Input input = new Input();

        String nameString = "one,two,three";

        String[] names = input.separateNames(nameString);

        Assertions.assertThat(names[0]).isEqualTo("one");
        Assertions.assertThat(names[1]).isEqualTo("two");
        Assertions.assertThat(names[2]).isEqualTo("three");
    }

    @Test
    @DisplayName("n개의 자동차 생성 확인")
    void initCarTest() {
        Race race = new Race();
        Input input = new Input();

        String nameString = "one,two,three";

        String[] names = input.separateNames(nameString);

        ArrayList<Car> carList = race.initCar(names);

        for (int i = 0; i < 3; i++) {
            Assertions.assertThat(carList.get(i).getName()).isEqualTo(names[i]);
            Assertions.assertThat(carList.get(i).getCurrentLocation()).isEqualTo(0);

        }
    }

    @Test
    @DisplayName("race 동작 확인")
    void startRaceTest() {
        Race race = new Race();
        Input input = new Input();

        String nameString = "one,two,three";

        String[] names = input.separateNames(nameString);

        ArrayList<Car> carList = race.initCar(names);

        ArrayList<Car> raceResult = race.startRace(carList);

        for (int i = 0; i < 3; i++) {
            Assertions.assertThat(raceResult.get(i).getName()).isEqualTo(names[i]);
            Assertions.assertThat(raceResult.get(i).getCurrentLocation()).isBetween(0, 1);
        }
    }

    @Test
    @DisplayName("최대 숫자 구하는 동작 확인")
    void getMaxNumberTest() {
        Race race = new Race();

        ArrayList<Car> carList = raceList();

        int max = carList.get(0).getCurrentLocation();
        int index = 0;
        for (int i = 0; i < carList.size(); i++) {
            index = race.getMaxNumber(carList.get(i), max, index, i);
        }
        Assertions.assertThat(carList.get(index).getCurrentLocation()).isEqualTo(5);
    }

    @Test
    @DisplayName("우승자 구하기")
    void getWinnerTest() {
        Race race = new Race();

        ArrayList<Car> carList = raceList();
        ArrayList<String> raceResult = race.getWinner(carList);

        for (int i = 0; i < raceResult.size(); i++) {
            Assertions.assertThat(carList.get(i).getName()).isEqualTo("one");
        }
    }

    @Test
    @DisplayName("중복 우승자 구하기")
    void checkWinnersInArrayTest() {
        Race race = new Race();

        ArrayList<Car> carList = raceList();


        carList.get(1).severalForward(5);

        ArrayList<String> winners = new ArrayList<>();

        for (int i = 0; i < carList.size(); i++) {
            race.checkWinnersInArray(carList, winners, 5, i);
        }

        Assertions.assertThat(winners.size()).isEqualTo(2);
        Assertions.assertThat(winners.get(0)).isEqualTo("one");

    }

    @Test
    @DisplayName("우승자 중 중복 체크")
    void checkDuplication() {
        Race race = new Race();

        ArrayList<Car> carList = raceList();

        carList.get(1).severalForward(5);

        int result = race.checkDuplication(carList, 5, 1);

        Assertions.assertThat(result).isEqualTo(1);
    }
}
