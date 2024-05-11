package controller;
import view.Input;
import domain.Car;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;

public class RacingCarMain {
    public void run(){
        //자동차 이름이 저장된 array: carNames로 저장
        //자동차 수?
        //시도회수: num
        final List<String> carNames = Input.readCarNames();
        int numberOfCars = carNames.size();
        final int attemptNum = Input.readAttemptNumber();
        Car.carRun(carNames, attemptNum, numberOfCars);

    }
}
