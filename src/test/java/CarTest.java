import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차 움직임 기능 테스트")
    public void moveTest() {
        Car car = new Car("부릉부릉");
        int location = car.getLocation();

        // 초기 위치 테스트
        Assertions.assertThat(location).isEqualTo(0);

        // 10번 랜덤 돌리기
        for (int i = 0; i < 10; i++) {
            car.move();
        }

        // 자동차가 멈췄다면 위치가 변하지 않을 수 있음을 확인
        Assertions.assertThat(car.getLocation()).isBetween(location, location + 10);
    }

    @Test
    @DisplayName("작명 기능 테스트")
    public void nameTest() {
        Car car = new Car("꼬마자동차");

        // 기본 이름 테스트
        Assertions.assertThat(car.getName()).isEqualTo("꼬마자동차");

        // 이름 변경 테스트
        car.setName("UAZ");
        Assertions.assertThat(car.getName()).isEqualTo("UAZ");
    }
}
