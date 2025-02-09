import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    final private List<Car> cars;
    private List<Car> winners;

    //Race 생성자 : ","를 이용해 구분하여 레이스에 참가하는 차량의 이름을 입력
    public Race(String nameOfCars){
        String[] carNames = nameOfCars.split(",");

        cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    //getter
    public List<Car> getWinner() {
        return winners;
    }

    //레이스 실행
    public void runRace(int round){
        //주어진 횟수동안 이동
        for(int i=0; i<round; i++){
            moveAllCars();
        }

        //승자 구하기
        checkWinners(calcMaxLocation());
    }

    //모든 차량 이동
    private void moveAllCars(){
        for(Car car: cars){
            car.move(new Random().nextInt(10));
            System.out.print(car.getName() + " : ");
            printCarProgress(car);
            System.out.println();
        }
        System.out.println();
    }

    private void printCarProgress(Car car){
        for(int i = 0; i < car.getLocation(); i++){
            System.out.print("-");
        }
    }

    //최대 거리 구하기
    private int calcMaxLocation(){
        int maxLocation = -1;
        for(Car car:cars){
            maxLocation = Math.max(maxLocation, car.getLocation());
        }

        return maxLocation;
    }

    //승자 구하기
    private void checkWinners(int maxLocation){
        winners = new ArrayList<>();

        for(Car car: cars){
            addWinners(car, maxLocation);
        }
    }

    //승자 추가하기
    private void addWinners(Car car, int maxLocation){
        if(car.getLocation() == maxLocation){
            winners.add(car);
        }
    }

}
