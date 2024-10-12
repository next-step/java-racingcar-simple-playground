import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Assertions.*;


import model.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import service.FixedNumGenerator;

public class CarTest {

  @Nested
  @DisplayName("생성테스트")
  public class createTest {

    @Test
    void 차량은_이름을_가진다() {
      final String name = "steve";
      final Car car = new Car(name);

      assertThat(car.getName()).isEqualTo(name);
    }
  }


  @Nested
  @DisplayName("움직임테스트")
  public class moveTest {

    @Test
    @DisplayName("전진테스트")
    public void 4_이상의_수는_차량을_전진시킨다() {

      final FixedNumGenerator fixedNumGenerator = new FixedNumGenerator(3);

      final Car car = new Car("steve", fixedNumGenerator);

      car.move();

      int expect = 0;
      int actual = car.getPos();

      assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("멈춤테스트")
    public void stopTest() {

      final FixedNumGenerator fixedNumGenerator = new FixedNumGenerator(3);
      final Car car = new Car("steve", fixedNumGenerator);

      car.move();

      int expect = 0;
      int actual = car.getPos();

      assertThat(actual).isEqualTo(expect);
    }

    @Test
    @DisplayName("예외테스트")
    public void exceptionTest() {

      final FixedNumGenerator fixedNumGenerator = new FixedNumGenerator(10);
      final Car car = new Car("steve", fixedNumGenerator);

      car.move();

      assertThatThrownBy(() -> car.move())
          .isInstanceOf(RuntimeException.class);

    }
  }
}
