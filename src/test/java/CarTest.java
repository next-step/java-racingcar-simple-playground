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
    public void 수가_4_이상일_때_전진한다() {

      final FixedNumGenerator fixedNumGenerator = new FixedNumGenerator(3);

      final Car car = new Car("steve", fixedNumGenerator);

      car.move();

      int expect = 0;
      int actual = car.getPos();

      assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void 수가_4_미만일_때_멈춘다() {

      final FixedNumGenerator fixedNumGenerator = new FixedNumGenerator(3);
      final Car car = new Car("steve", fixedNumGenerator);

      car.move();

      int expect = 0;
      int actual = car.getPos();

      assertThat(actual).isEqualTo(expect);
    }

    @Test
    public void 수가_잘못된_범위라면_예외를_던진다() {

      final FixedNumGenerator fixedNumGenerator = new FixedNumGenerator(10);
      final Car car = new Car("steve", fixedNumGenerator);

      car.move();

      assertThatThrownBy(() -> car.move())
          .isInstanceOf(RuntimeException.class);

    }
  }
}
