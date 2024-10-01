import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TestRacingCar {

  private RacingCar racingCar;

  @BeforeEach
  void setUp() {
    racingCar = new RacingCar("myRacingCar");
  }

  @Test
  @DisplayName("레이싱카 전진 확인")
  public void testGo(){
    //given
    int random = 9;

    //when
    int actual = racingCar.moveByRandom(random);
    int expected = 1;

    //then
    assertThat(actual).isEqualTo(expected);
  }
  @Test
  @DisplayName("레이싱카 정지 확인")
  public void testStop(){
    //given
    int random = 0;

    //when
    int actual = racingCar.moveByRandom(random);
    int expected = 0;

    //then
    assertThat(actual).isEqualTo(expected);
  }

  @Test
  @DisplayName("레이싱카의 이름이 유효하지 않을 시 에러 발생")
  public void testValidName(){
    //given

    //when

    //then
    assertThatThrownBy(() -> {
      racingCar.setName(null);
    }).isInstanceOf(IllegalArgumentException.class);
  }
}
