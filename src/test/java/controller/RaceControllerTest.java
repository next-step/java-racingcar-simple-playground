package controller;

import components.CyclingNumberGenerator;
import model.Car;
import org.junit.jupiter.api.*;
import view.InputView;
import view.OutputView;

import java.io.ByteArrayInputStream;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Scanner;

class RaceControllerTest {
    RaceController raceController;
    MockCars cars = new MockCars();

    @Test
    @DisplayName("통합 테스트 : 주어진 횟수만큼 자동차를 전진시키려 한다.")
    protected void testPlayRace() {
        //given
        cars.addCar(new Car("alice", new CyclingNumberGenerator(new int[] {4})));
        Scanner scanner = new Scanner(new ByteArrayInputStream("3".getBytes()));
        raceController = new RaceController(new InputView(scanner), new OutputView(), cars);

        //when
        raceController.playRace();

        //then
        Assertions.assertEquals(3, cars.getTryMovingEveryCarExecuteCount());
    }

    @Test
    @DisplayName("통합 테스트 : 현제 자동차 상황은 주어진 횟수만큼 출력, 우승자는 1번 출력한다.")
    protected void testPlayRaceOutput() {
        //given
        cars.addCar(new Car("alice", new CyclingNumberGenerator(new int[] {4})));
        Scanner scanner = new Scanner(new ByteArrayInputStream("3".getBytes()));
        MockOutputView mockOutputView = new MockOutputView();
        raceController = new RaceController(new InputView(scanner), mockOutputView, cars);

        //when
        raceController.playRace();

        //then
        Assertions.assertEquals(3, mockOutputView.getPrintCurrentRaceStateExecuteCount());
        Assertions.assertEquals(1, mockOutputView.getPrintWinnersExecuteCount());
    }
}