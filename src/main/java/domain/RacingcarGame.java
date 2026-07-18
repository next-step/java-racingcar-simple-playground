package domain;

import java.util.*;
import view.InputView;
import view.ResultView;

public class RacingcarGame {
    private List<Car> carList = new ArrayList<>(); // 자동차 객체를 잠는 리스트
    private int moveCount; // 자동차들이 이동할 횟수를 저장

    // 랜덤 생성기, Car 생성자에 들어감
    private final NumberGenerator numberGenerator = new RandomNumberGenerator();

    /*
     *  carList에 car 추가
     * */
    public void addCar(Car car) {
        carList.add(car);
    }

    /*
     * 게임 실행, 자동차는 이름 5자 이하 제한,
     * */
    public void run() {
        String[] nameArr;

        while (true) {
            try {
                carList.clear();

                nameArr = InputView.inputCarNames();

                putNamesToList(nameArr); // Car 객체를 생성하며 이름 길이 검증, 오류 발생시 재입력 요구

                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

        moveCount = InputView.inputMoveCount(); // 이동 횟수 입력

        playGame(); // 게임 실행
    }

    /*
     * nameArr에서 이름을 하나씩 꺼내 domain.Car 객체 생성 후 carList에 add
     * */
    public void putNamesToList(String[] nameArr) {
        for (int i = 0; i < nameArr.length; i++) {
            Car car = new Car(nameArr[i], numberGenerator);
            carList.add(car);
        }
    }

    /*
     * Car를 한 번 이동시키기
     * */
    public void addDistance() {
        for (Car car : carList) {
            car.move();
        }
    }

    /*
     * moveCount 만큼 게임을 실행
     * */
    public void playGame() {
        System.out.println("\n실행결과");

        for (int i = 0; i < moveCount; i++) { // moveCount만큼 반복
            addDistance();
            ResultView.printCarDistance(carList);
        }
        ResultView.printWinners(getWinner());
    }


    /*
     * 우승 자동차 구하기
     * */
    public ArrayList<Car> getWinner() {
        ArrayList<Car> winners = new ArrayList<>(); // 우승 자동차 저장할 리스트
        int max = compare(); // 가장 높은 이동거리를 max에 저장

        for (Car car : carList) { // carList에서 이동거리가 max와 같은 Car를 winners 리스트에 저장
            putWinner(max, car, winners);
        }
        return winners;
    }

    // 차 비교하기
    public int compare() {
        int max = 0; 
        for (Car car : carList) {
            max = maxDistance(max, car);
        }
        return max;
    }

    // Car의 누적거리가 max보다 크면 max값 갱신
    public int maxDistance(int max, Car car) {
        if (max < car.getTotalDistance()) {
            max = car.getTotalDistance();
        }
        return max;
    }

    // max와 누적거리가 같은 Car를 winner에 담기
    public void putWinner(int max, Car car, ArrayList<Car> winners) {
        if (max == car.getTotalDistance()) {
            winners.add(car);
        }
    }
}