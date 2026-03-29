
import model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CarTest {
    @Test
    @DisplayName("Car이름을 A로 설정하면_이름이 A로 호출된다")
    public void Test_getName() {
        //Given:'A'라는 이름을 부여받을때
        Car car = new Car("A");
        //When:이름을 조회하면
        String name=car.getName();
        //then:이름이 'A'여야한다
        Assertions.assertEquals("A",name);
    }

    @Test
    @DisplayName("자동차가 0-3 사이 값이 나오면 정지함.")
    public void Test_underForwardThreshold() {
        //Given:'A'라는 차가 생성될때,
        Car car = new Car("A");
        //When:3의 값을 받으면
        car.move(3);
        //Then:위치가 0이다
        Assertions.assertEquals(0, car.getPosition());
    }

    @Test
    @DisplayName("자동차가 4-9사이의 값이 나오면 전진함.")
    public void Test_overForwardThreshold() {
        //Given:'A'라는 자동차가 생성될때,
        Car car = new Car("A");
        //When:4의 값을 받으면
        car.move(4);
        //Then위치가 1이 된다.
        Assertions.assertEquals(1, car.getPosition());
    }
}
