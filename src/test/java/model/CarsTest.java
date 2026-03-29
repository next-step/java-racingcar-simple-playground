package model;

import components.CyclingNumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    Cars cars;
    @BeforeEach
    protected void testSetup () {
        cars = new Cars(new ArrayList<Car>());
    }

    @Test
    @DisplayName("각 실행마다 모든 차가 전진하려 한다.")
    protected void testTryMovingEveryCar() {
        // given
        cars.addCar(new Car("0", new CyclingNumberGenerator(new int[] {9})));
        cars.addCar(new Car("1", new CyclingNumberGenerator(new int[] {9})));

        // when
        cars.tryMovingEveryCar();

        // result
        List<String> winners = cars.getMaxDistanceCarNames();
        Assertions.assertEquals(2, winners.size());
        assertThat(winners).hasSameElementsAs(Arrays.asList("1", "0"));
    }

    @Test
    @DisplayName("가장 멀리 간 자동차 이름만 반환한다.")
    protected void testGetMaxDistanceCarNames() {
        // given
        cars.addCar(new Car(Integer.toString(0), new CyclingNumberGenerator(new int[] {3})));
        cars.addCar(new Car(Integer.toString(1), new CyclingNumberGenerator(new int[] {9})));

        //when
        cars.tryMovingEveryCar();

        // result
        List<String> winners = cars.getMaxDistanceCarNames();
        Assertions.assertEquals(1, winners.size());
        assertThat(winners).hasSameElementsAs(List.of("1"));
    }

    @Test
    @DisplayName("가장 멀리 간 자동차가 한 대 이상일 수 있다.")
    protected void testGetMaxDistanceCarMultipleNames() {
        // given
        cars.addCar(new Car(Integer.toString(0), new CyclingNumberGenerator(new int[] {9})));
        cars.addCar(new Car(Integer.toString(1), new CyclingNumberGenerator(new int[] {9})));

        //when
        cars.tryMovingEveryCar();

        // result
        List<String> winners = cars.getMaxDistanceCarNames();
        Assertions.assertEquals(2, winners.size());
        assertThat(winners).hasSameElementsAs(List.of("0", "1"));
    }

    @Test
    @DisplayName("모든 자동차의 정보를 반환한다.")
    protected void testGetRacerInfo() {
        // given
        cars.addCar(new Car(Integer.toString(0), new CyclingNumberGenerator(new int[] {3})));
        cars.addCar(new Car(Integer.toString(0), new CyclingNumberGenerator(new int[] {4})));
        cars.addCar(new Car(Integer.toString(1), new CyclingNumberGenerator(new int[] {9})));

        //when
        cars.tryMovingEveryCar();

        // result
        Map<String, List<Integer>> carState = cars.getRacerInfo();
        Assertions.assertEquals(2, carState.size());

        Assertions.assertEquals(2, carState.get("0").size());
        assertThat(carState.get("0")).hasSameElementsAs(Arrays.asList(0,1));
        Assertions.assertEquals(1, carState.get("1").size());
        assertThat(carState.get("1")).hasSameElementsAs(List.of(1));
    }
}
