import Domain.Car;
import Domain.CarList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarListTest {

    Random random=new Random();

    @Test
    @DisplayName("자동차가 잘 만들어지는지 테스트")
    void 자동차가_잘_만들어지는지_테스트(){
        List<Car> cars=new ArrayList<>();
        int n= random.nextInt(10);  //최대 10개로 잡고 테스트
        for(int i=0;i<n;i++) {
            cars.add(new Car("car" + i));
        }
        assertEquals(n,cars.size());
    }

    @Test
    @DisplayName("자동차들이 레이싱을 진행함")
    void 자동차들이_레이싱을_진행함(){
        List<Car> cars=new ArrayList<>();
        int n= random.nextInt(10);  //최대 10개로 잡고 테스트
        for(int i=0;i<n;i++) {
            cars.add(new Car("car" + i));
        }
        for(Car car:cars){
            int a= random.nextInt(10);
            car.carMove(a);
            assertTrue(car.getPosition()>=0 || car.getPosition()<=9);
        }
    }

    @Test
    @DisplayName("우승자 찾기")
    void 우승자_찾기(){
        List<Car> cars=new ArrayList<>();
        int n= random.nextInt(10);  //최대 10개로 잡고 테스트
        for(int i=0;i<n;i++) {
            cars.add(new Car("car" + i));
        }
        for(Car car:cars){
            int a= random.nextInt(10);
            car.carMove(a);
        }
        CarList carListManager=new CarList(cars);
        Car winner=carListManager.findMaxPosition();

        assertNotNull(winner);  //우승자가 NULL 아닌지 확인
        assertTrue(winner.getPosition()>0); //우승자의 위치가 0보다 큰지 확인
    }
}
