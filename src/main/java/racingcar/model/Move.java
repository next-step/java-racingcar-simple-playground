package racingcar.model;

import racingcar.view.InputView;

import java.util.List;
import java.util.Random;

public class Move {
    //<메소드>
    //랜덤 값 생성
    private int getRandomValue() {
        Random random = new Random();
        return random.nextInt(10);
    }

    //움직일 수 있는 지 확인
    public boolean isMovable(int randomValue) {
        int standardNum=4;
        return randomValue >= standardNum;
    }

    //움직이는 코드
    public void move1Space(Car car) {
        if (isMovable(getRandomValue())) {
            car.positionFoward(car.getPosition() + 1);
        }
    }

    //n대의 자동차를 한 바퀴 게임 실행
    public void moveTurnAround(List<Car> carList) {
        for (Car car : carList) {
            move1Space(car);
        }
    }

    //n바퀴 게임 실행
    public void moveTurnAroundNTimes(int n, List<Car> carList, InputView inputView) {
        for (int i = 0; i < n; i++) {
            moveTurnAround(carList);
            inputView.PrintMoveTurnAround(carList);
            System.out.println();
        }
    }
}
