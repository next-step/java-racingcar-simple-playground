import java.util.*;
import java.util.Scanner;

public class RacingcarGame {
    private List<Car> carList = new ArrayList<>(); // 자동차 객체를 잠는 리스트
    private Scanner sc = new Scanner(System.in);
    private String[] nameArr; // 자동차들의 이름을 저장하는 문자열 배열
    public int moveCount; // 몇번 이동할지

    /*
     *  carList에 car 추가
     * */
    public void addCar(Car car) {
        carList.add(car);
    }

    /*
     * 게임 실행
     * */
    public void run() {
        // 1) 차 이름 입력받기 -> 이름 입력받고, 5자 이하이면 통과, 아니면 반복
        while (true) {
            inputCarNames();
            if (checkNames()) // 전부 5자 이하면 통과
                break;
            System.out.println("이름은 5자 이하로 입력해야 합니다.");
        }
        putNamesToList(nameArr); // 리스트에 Car 객체들 담기

        inputMoveCount(); // 이동 횟수 입력

        playGame(); // 게임 실행
    }

    /*
     * 이름 입력받기
     * */
    public void inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)");
        String names = sc.nextLine();
        nameArr = names.split(",");
    }

    /*
     * 이름이 들어있는 배열 순회
     * */
    public boolean checkNames() {
        for (int i = 0; i < nameArr.length; i++) {
            if (!checkNameLength(nameArr[i]))
                return false;
        }
        return true;
    }

    /*
     * 이름이 5자 이하인지 검사
     * */
    public boolean checkNameLength(String name) {
        if (name.length() <= 5) return true;
        return false;
    }

    /*
     * nameArr에서 이름을 하나씩 꺼내 Car 객체 생성 후 carList에 add
     * */
    public void putNamesToList(String[] nameArr) {
        for (int i = 0; i < nameArr.length; i++) {
            Car car = new Car(nameArr[i]);
            carList.add(car);
        }
    }

    /*
     * 이동 횟수 입력받기
     * */
    public void inputMoveCount() {
        System.out.println("시도할 횟수는 몇회인가요?");
        moveCount = sc.nextInt();
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
     * 현재 자동차들의 이동 거리 출력하기
     * */
    public void printCarDistance() {
        for (Car car : carList) {
            System.out.print(car.getName() + " : ");
            printDistance(car);
            System.out.println("\n");
        }
        System.out.println("\n");
    }

    /*
     * 자동차의 이동거리를 '-'로 시각적으로 출력
     * */
    public void printDistance(Car car) {
        for (int i = 0; i < car.getTotalDistance(); i++) {
            System.out.print("-");
        }
    }

    /*
     * moveCount 만큼 게임을 실행
     * */
    public void playGame() {
        System.out.println("실행 결과");

        for (int i = 0; i < moveCount; i++) { // moveCount만큼 반복
            addDistance();
            printCarDistance();
        }
        printWinners();
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
        if (max < car.getTotalDistance()) max = car.getTotalDistance();
        return max;
    }

    // max와 누적거리가 같은 Car를 winner에 담기
    public void putWinner(int max, Car car, ArrayList<Car> winners) {
        if (max == car.getTotalDistance()) winners.add(car);
    }

    /*
     * 우승 자동차 출력
     * */
    public void printWinners() {
        ArrayList<Car> winners = getWinner();

        StringJoiner joiner = new StringJoiner(", "); // 중요! StringJoiner
        // StringJoiner 없이 구현하려면 쉼표 출력 여부를 검사하는 메서드 추가 필요

        for (Car car : winners) {
            joiner.add(car.getName());
        }

        System.out.println(joiner + "가 최종 우승했습니다.");
    }
}