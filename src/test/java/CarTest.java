import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    void random값이_4이상이면_position값이_증가한다(){
        Car car = new Car("test1");

        car.move(4);

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void random값이_3이하면_position값은_변하지_않는다(){
        Car car = new Car("test1");

        car.move(3);

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 전진_조건과_정지_조건이_섞이면_전진한_횟수만큼만_position값이_증가한다(){
        Car car = new Car("test1");

        car.move(4);
        car.move(2);
        car.move(8);
        car.move(1);

        assertThat(car.getPosition()).isEqualTo(2);
    }
}
