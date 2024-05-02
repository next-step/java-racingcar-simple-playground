import Domain.Car;
import Domain.RacingCar;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("랜덤 수가 잘 만들어지는 지 테스트")
    void 랜덤_수가_잘_만들어지는_지_테스트(){
        Car car=new Car("람보르기니");
        int random= RacingCar.getRandom();
        assertTrue(random>=0 || random<=9);
    }

    @Test
    @DisplayName("각 자동차의 랜덤 값을 설정하고 전진or멈춤 결정하는 메소드")
    void 각_자동차의_랜덤_값을_설정하고_전진or멈춤_결정하는_메소드(){
        Car car=new Car("test1");
        car.carMove(RacingCar.getRandom());
        assertTrue(car.getPosition()>=0);
    }

    @Test
    @DisplayName("가장 멀리 이동한 거리를 찾는 메소드")
    void 가장_멀리_이동한_거리를_찾는_메소드(){
        int max=-1,i=0;
        List<Car> cars=new ArrayList<>();
        cars.add(new Car("test1"));
        cars.add(new Car("test2"));
        for(Car car:cars){
            car.setPosition(i++); //test1의 위치:0 test2의 위치:1
        }
        for(Car car:cars){
            if(car.getPosition()>max)
                max= car.getPosition();
        }
        assertEquals(max,1);
    }

    @Test
    @DisplayName("우승자를 찾는 메소드")
    void 우승자를_찾는_메소드(){
        int max=1,i=0;
        List<Car> cars=new ArrayList<>();
        cars.add(new Car("test1"));
        cars.add(new Car("test2"));
        for(Car car:cars){
            car.setPosition(i++); //test1의 위치:0 test2의 위치:1
        }
        List<Car> winner=new ArrayList<>();
        for(Car car:cars){
            if(car.getPosition()==max)
                winner.add(car);
        }
        assertEquals(winner.get(0).getName(),"test2");
    }
}
