import java.util.List;

public class CarList {

    private List<Car> carList;

    public CarList(List<Car> carList){  //리스트에 만들어진 자동차를 하나씩 넣어준다
        this.carList=carList;
    } //add해줄거면 필요가 없지 않나..?
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
}
