import java.util.*;
import java.util.Scanner;

public class RacingcarGame {
    private List<Car> carList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private String[] nameArr;

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
        while(true) {
            inputCarNames();
            if(checkNames()) // 전부 5자 이하면 통과
                break;
            System.out.println("이름은 5자 이하로 입력해야 합니다.");
        }
        putNamesToList(nameArr);

        // (3) 이동 횟수 입력 >> nextInt

        // (4) 최종 우승자 출력
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
        for(int i = 0; i < nameArr.length; i++) {
            if (!checkNameLength(nameArr[i]))
                return false;
        }
        return true;
    }

    /*
    * 이름이 5자 이하인지 검사
    * */
    public boolean checkNameLength(String name) {
        if(name.length() <= 5) return true;
        return false;
    }

    /*
    * nameArr에서 이름을 하나씩 꺼내 Car 객체 생성 후 carList에 add
    * */
    public void putNamesToList(String[] nameArr) {
        for(int i = 0; i < nameArr.length; i++) {
            Car car = new Car(nameArr[i]);
            carList.add(car);
        }
    }

    /*
    * 우승 자동차 구하기
    * */
    public ArrayList<Car> getWinner() {
        ArrayList<Car> winners = new ArrayList<>();
        int max = compare();

        for(Car car : carList) {
            putWinner(max, car, winners);
        }

        return winners;
    }
    // 차 비교하기
    public int compare() {
        int max = 0;
        for(Car car : carList) {
            max = maxDistance(max, car);
        }
        return max;
    }

    // Car의 누적거리가 max보다 크면 max값 갱신
    public int maxDistance(int max, Car car) {
        if(max < car.getTotalDistance()) max = car.getTotalDistance();
        return max;
    }

    // max와 누적거리가 같은 Car를 winner에 담기
    public void putWinner(int max, Car car, ArrayList<Car> winners) {
        if(max == car.getTotalDistance()) winners.add(car);
    }


}
