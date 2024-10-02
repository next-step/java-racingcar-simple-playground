import domain.Car;
import domain.Riding;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RidingTest {

    @Test
    @DisplayName("4이상이면 전진하고, 3이하면 정지한다.")
    public void rideByRandomValue() {
        //given
        Car car1 = new Car("자동차 이름1", 6);
        Car car2 = new Car("자동차 이름2", 6);
        int randomValue1 = 4;
        int randomValue2 = 3;
        Riding riding = new Riding();
        //when

        riding.ride(car1, randomValue1);
        riding.ride(car2, randomValue2);

        //then
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(car1.getCurrentDistance()).isEqualTo(7);
        softAssertions.assertThat(car2.getCurrentDistance()).isEqualTo(6);
        softAssertions.assertAll();
    }
}
