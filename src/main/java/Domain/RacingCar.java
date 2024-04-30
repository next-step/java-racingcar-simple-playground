package Domain;

import Domain.Car;
import Domain.CarList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCar {

    public RacingCar(){}

    //0~9 사이의 숫자 리턴
    public static int getRandom(){
        Random random=new Random();
        return random.nextInt(10);
    }

    //각 자동차의 랜덤 값을 설정하고 전진 or 멈춤 결정하는 메소드
    public int setCarPosition(Car car){
        car.carMove(getRandom());
        return car.getPosition();
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

}
