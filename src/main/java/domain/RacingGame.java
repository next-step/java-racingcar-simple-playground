package domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private  static final int RANDOM_BOUND = 10;

    private final List<Car> cars; // 경주에 참여하는 모든 자동차 저장
    private final Random random; // 난수 만들이 위한 객체

    public RacingGame(List<String> carNames) { // 자동차 이름 목록 전달받아 경주 게임 만듬
        this.cars = createCars(carNames); // 문자열로 된 자동차 이름들 실제 Car객체로 변환
        this.random = new Random(); // 난수 생성할 Random객체 만듬
    }
    public void play(int attemptCount) { // 자동차 경주 전체 실행
        ResultView.printResultTitle(); // 다음 문자 출력

        for (int count=0; count<attemptCount; count++) { // 사용자가 입력한 횟수만큼 반복
            playOneRound(); // 자동차 경주 한 라운드 실행
        }
        ResultView.printWinners(findWinners()); // 모든 경주 끝나면 우승자 찾아 츌력
    }
    private List<Car> createCars(List<String> carNames) { // 자동차 이름 목록> 자동차 객체 목록
        List<Car> cars = new ArrayList<>(); // 자동차 객체 저장할 빈 리스트 만듬

        for (String carName : carNames) { // 입력된 자동차 이름 하나씩 꺼냄
            cars.add(new Car(carName)); // 이름 이용해 자동차 객체 만들고 리스트에 추가
        }
        return  cars; // 완성된 자동차 목록 반환
    }
    private void playOneRound() { // 자동차 경주 한 번 담당
        moveAllCars(); // 모든 자동차 움직일지 판단
        ResultView.printCars(cars); // 이동 끝난 자동차들 현재 위치 출력
    }
    private void moveAllCars() { // 모든 자동차 한 번씩 이동
        for (Car car : cars) {
            moveCar(car); // 꺼낸 자동차 한 대의 이동 여부 결정
        }
    }
    private void moveCar(Car car) { // 자동차 한 대의 이동 담당
        int randomNumber = random.nextInt(RANDOM_BOUND); // 0부터 9까지 숫자 중 하나 무작위로 생성
        car.move(randomNumber); // 발생한 난수를 move메서드에 전달
    }
    private List<String> findWinners() { // 최종 우승자들의 이름 구함
        int maxPosition = findMaxPosition(); // 자동차 중 가장 큰 위치 구함
        List<String> winners = new ArrayList<>();

        for (Car car : cars) {
           addWinner(car, maxPosition, winners); // 자동차의 위치가 최대값과 같다면 우승자 목록에 추가
        }
        return winners; // 완성된 우승자 이름 목록 반환
    }
    private int findMaxPosition() { // 자동차 중 가장 멀리 간 위치 구함
        int maxPosition = 0; // 최대 위치 초기값 0 설정

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition()); // 기존 최댓값과 현재 자동차의 위치 중 더 큰 값 저장
        }
        return maxPosition; // 구한 최대 위치 반환
    }
    private void addWinner(Car car, int maxPosition, List<String> winners) { // 현재 자동차가 우승자인지 판단
        if (car.getPosition() == maxPosition) { // 현재 자동차의 위치가 최대 위치와 같은지 확인
            winners.add(car.getName()); // 같다면 자동차 이름을 우승자 목록에 추가
        }
    }
}