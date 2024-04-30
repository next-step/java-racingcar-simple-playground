import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {

    public RacingCar(){}

    //각 자동차의 랜덤 값을 설정하고 전진 or 멈춤 결정하는 메소드
    public int setCarPosition(Car car){
        car.carMove(GetRandom.getRandom());
        return car.getPosition();
    }
    //결과 화면에 출력하기 위해 각 자동차의 이름을 출력하는 메소드
    public void printCarNameOutput(CarList carList){
        List<Car> cars=carList.getCarList();
        for(Car car:cars){
            System.out.print(car.getName()+" : ");  //각 이름까지 출력
            printCarPositionOutput(car);    //이동거리 출력은 다른 함수 호출
        }
    }
    //결과 화면에 출력하기 위해 각 자동차의 위치를 출력하는 메소드
    public void printCarPositionOutput(Car car){
        car.setPosition(setCarPosition(car));
        for(int i=0;i<car.getPosition();i++)
            System.out.print("-");
        System.out.println();
    }
    //가장 멀리 이동한 거리를 찾는 메소드
    public int findMaxPosition(CarList carList){
        int max=-1;
        List<Car> cars=carList.getCarList();
        for(Car car:cars){
            if(car.getPosition()>max)
                max=car.getPosition();
        }
        return max;
    }
    //우승자를 찾는 메소드
    public List<Car> findWinners(CarList carList){
        int max=findMaxPosition(carList);
        List<Car> cars=carList.getCarList();
        List<Car> winners=new ArrayList<>();
        for(Car car:cars) {
            if (car.getPosition() == max)
                winners.add(car);
        }
        return winners;
    }
    //우승자 출력 메소드
    public void printWinners(CarList carList){
        int i=0;
        List<Car> winners=findWinners(carList);
        for(Car car:winners){
            System.out.print(car.getName());
            i++;
            if(winners.size()>1 && i!= winners.size())
                System.out.print(", ");
        }
        System.out.println("가 최종 우승했습니다.");
    }
}
