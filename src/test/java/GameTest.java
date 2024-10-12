import static org.assertj.core.api.Assertions.*;

import java.util.List;
import model.Car;
import model.RacingGame;
import org.junit.jupiter.api.Test;

public class GameTest {

  @Test
  public void 차량을_원하는_수만큼_생성시킨다() {
    final RacingGame racingGame = new RacingGame();

    List<String> nameList = List.of("Steve", "Alex", "James");

    racingGame.createCarList(nameList);
    List<String> actual = racingGame.getCarList().stream().map(Car::getName).toList();

    assertThat(actual).containsExactlyInAnyOrderElementsOf( nameList );
  }

  @Test
  public void 차량은_N번의_라운드동안_움직일_수_있다() {

  }

  @Test
  public void 라운드_결과를_출력한다() {

  }

  @Test
  public void 승자를_출력한다() {

  }

  @Test
  public void 참가하는_차량이_없다면_예외를_던진다() {

  }

  @Test
  public void 차량이름이_비었다면_예외를_던진다() {

  }

  @Test
  public void 차량이름이_중복이라면_예외를_던진다() {

  }

  @Test
  public void 시도횟수가_음수라면_예외를_던진다() {

  }

}
