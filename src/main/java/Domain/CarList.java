package Domain;

import Domain.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarList {

    private List<Car> carList;
    Random random=new Random();

    public CarList(List<Car> carList){  //리스트에 만들어진 자동차를 하나씩 넣어준다
        this.carList=carList;
    }
    public CarList(String[] carNames){
        carList=new ArrayList<>();  //초기화 안 해줘서 오류 발생 초기화되지 않은 상태에서 add를 했기 때문에 발생한거임
        for(int i=0;i< carNames.length;i++) {
           // System.out.println("들어옴");
            carList.add(new Car(carNames[i]));
           // System.out.println(carNames[i] + "가 만들어짐");
        }
       // System.out.println(carList.size());
    }
    public Car findMaxPosition(){   //우승 차 찾기 메소드
        Car winner=new Car("빈 차");
        int max=0;
        for(Car car:carList){
            if(max<car.getPosition()){
                max= car.getPosition();
                winner=car;
            }
        }
        return winner;
    }
    public int getCarListSize(){
        return carList.size();
    }

    public List<Car> getCarList(){
        return carList;
    }

}
