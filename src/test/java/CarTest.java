import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CarTest {

    @Test
    @DisplayName("자동차가 잘 만들어지는 지 테스트")
    void 자동차가_잘_만들어지는_지_테스트(){
        Car car=new Car("마세라티");
        assertEquals(car.getPosition(),0);
        assertEquals(car.getName(),"마세라티");
    }

    @Test
    @DisplayName("랜덤 수가 잘 만들어지는 지 테스트")
    void 랜덤_수가_잘_만들어지는_지_테스트(){
        Car car=new Car("람보르기니");
        int random= GetRandom.getRandom();
        assertTrue(random>=0 || random<=9);
    }

    @Test
    @DisplayName("숫자가 4 이상일 때 앞으로 가는 지 테스트")
    void 숫자가_4_이상일_때_앞으로_가는_지_테스트(){
        Car car=new Car("포르쉐");
        for(int i=4;i<=9;i++)
            car.carMove(i);
        assertTrue(car.getPosition()>=4);
    }

    @Test
    @DisplayName("숫자가 3 이하일 때 멈추는 지 테스트")
    void 숫자가_3_이하일_때_멈추는_지_테스트(){
        Car car=new Car("페라리");
        for(int i=0;i<=3;i++)
            car.carMove(i);
        assertEquals(car.getPosition(),0);
    }
}
