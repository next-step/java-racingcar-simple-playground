package View;

import Domain.Car;
import Domain.CarList;
import Domain.RacingCar;

import java.util.List;

public class OutputView {

    public static int cnt=0;
    RacingCar racingCar=new RacingCar();
    public static void printWinners(List<Car> winners){
        for(int i=0;i< winners.size();i++){
            System.out.print(winners.get(i).getName());
            if(i!=winners.size()-1)
                System.out.print(", ");
        }
        System.out.println("가 최종 우승했습니다.");
    }

    //결과 화면에 출력하기 위해 각 자동차의 이름을 출력하는 메소드
    public void printCarNameOutput(CarList carList){
        cnt++;
        if(cnt==1)
            System.out.println("실행 결과");
        List<Car> cars=carList.getCarList();
        for(Car car:cars){
            System.out.print(car.getName()+" : ");  //각 이름까지 출력
            printCarPositionOutput(car);    //이동거리 출력은 다른 함수 호출
        }
    }
    //결과 화면에 출력하기 위해 각 자동차의 위치를 출력하는 메소드
    public void printCarPositionOutput(Car car){
        car.setPosition(racingCar.setCarPosition(car));
        for(int i=0;i<car.getPosition();i++)
            System.out.print("-");
        System.out.println();
    }
}
