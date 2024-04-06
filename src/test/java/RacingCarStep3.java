import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class RacingCarStep3 {
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    String[] carNames; // 자동차의 이름
    int[] carLocations; // 각 자동차의 위치
    int cnt; // 주어진 횟수
    int n;   // 참여하는 자동차의 대수
    LinkedList<String> winnerList = new LinkedList<>();

    // 자동차의 carNames를 사용자로부터 입력받는 메서드
    public void getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분");
        carNames = scanner.nextLine().split(",");
    }

    // 자동차의 대수 n을 초기화해주는 메서드
    public void setN(){
        n = carNames.length;
    }

    // 주어진 횟수 cnt를 입력받아 정하는 메서드
    public void getCnt() {
        System.out.print("시도할 회수는 몇회인가요?");
        cnt = scanner.nextInt();
        scanner.nextLine();
    }

    // 자동차의 carLocations을 초기화해주는 메서드
    public void setCarLocations() {
        carLocations = new int[n];
        // int 배열을 선언하면 기본값으로 초기화 된다?
    }

    // 랜덤으로 나온 값에 대해서 차가 움직이는 메서드
    public void randomCarMoving(int carIndex) {
        if (random.nextInt(10) >= 4) {
            carLocations[carIndex]++;
        }
    }

    // 참여한 모든 차가 1번 움직이는 메서드
    public void randomAllCarsMoving() {
        for (int i = 0; i < n; i++) {
            randomCarMoving(i);
            printCarNameAndLoc(i);
        }
    }

    // 차의 이름과 현재 위치를 보이는 메서드
    public void printCarNameAndLoc(int carIndex){
        System.out.println(carNames[carIndex] + " : " + "-".repeat(carLocations[carIndex]));
    }

    // 차들이 cnt회 동안 반복
    public void racingGame() {
        System.out.println("실행 결과");
        for (int i = 0; i < cnt; i++) {
            randomAllCarsMoving();
            System.out.println();
        }

    }

    // carsLocation의 최댓값을 찾는 함수
    public int findMaxLocation() {
        int maxLo = Integer.MIN_VALUE;
        for (int carLocation : carLocations) {
            maxLo = Math.max(maxLo, carLocation);
        }
        return maxLo;
    }
    // 가장 멀리 간 차량의 index를 반환하는 메서드
    public void getWinners(int carLocation, int i, int maxLo) {
        if (carLocation == maxLo) {
            winnerList.add(carNames[i]);
        }
    }
    // 반점을 출력하는 메서드
    public void printsplit(int i){
        if (i+1 < winnerList.size()) {
            System.out.print(", ");
        }
    }
    // 우승자를 구하는 메서드
    public void winnerChecking() {
        for (int i = 0; i < carLocations.length; i++) {
            getWinners(carLocations[i], i, findMaxLocation());
        }
    }
    public void winnerPrinting(){
        for (int i = 0; i < winnerList.size(); i++) {
            System.out.print(winnerList.get(i));
            printsplit(i);
        }
        System.out.println("가 최종 우승했습니다.");
    }

    public static void main(String[] args) {
        RacingCarStep3 rcCar = new RacingCarStep3();
        rcCar.getCarNames(); // 참가 자동차 이름 입력
        rcCar.setN();        // 이름 입력 바탕으로 자동차 대수 n 초기화
        rcCar.getCnt();      // 횟수 cnt 입력
        rcCar.setCarLocations();
        rcCar.racingGame();  // 게임 실행
        rcCar.winnerChecking(); // 우승자 확인
        rcCar.winnerPrinting(); // 우승자 출력
    }
}
