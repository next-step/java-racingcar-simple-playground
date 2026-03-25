import java.util.*;

public class GetWinners {
    public static void getWinner(List<Car> cars) {
        int far=0;
        for(Car car:cars){
            if(car.position>far){
                far=car.position;
            }
        }
        List<String> winners=new ArrayList<>();
        for (Car car:cars){
            if(car.position==far){
                winners.add(car.name);
            }
        }
        String finalWinners=String.join(", ",winners);
        System.out.println(finalWinners+"가 최종 우승했습니다.");
    }
}
