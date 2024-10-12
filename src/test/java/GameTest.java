import static org.assertj.core.api.Assertions.*;

import Dto.GameResultDto;
import Dto.RoundResultDto;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.RacingGame;
import org.junit.jupiter.api.Test;
import validator.Validator;
import java.io.ByteArrayInputStream;
import view.InputView;
import view.OutputView;

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
  public void 라운드_결과를_출력한다() {
    final OutputView outputView = new OutputView();
    final List<RoundResultDto> result = new ArrayList<>();

    result.add(
        new RoundResultDto().builder()
        .name("Steve")
        .pos(5)
        .build()
    );

    String expected = "Steve : -----\n\n";

    OutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    outputView.printRoundResult( result );

    assertThat(out.toString()).isEqualTo(expected);
  }

  @Test
  public void 승자를_출력한다() {
    final OutputView outputView = new OutputView();
    final GameResultDto result = new GameResultDto().builder()
            .name( List.of("Steve", "Alex") )
            .build();

    String expected = "Steve, Alex가 최종 우승했습니다.\n";

    OutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    outputView.printWinner( result );

    assertThat(out.toString()).isEqualTo(expected);
  }

  @Test
  public void 참가하는_차량이_없다면_예외를_던진다() {
    final Validator validator = new Validator();

    List<String> nameList = List.of();

    assertThatThrownBy( () -> validator.validName(nameList) )
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  public void 차량이름이_비었다면_예외를_던진다() {
    final Validator validator = new Validator();

    List<String> nameList = List.of("Steve", "");

    assertThatThrownBy( () -> validator.validName(nameList) )
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  public void 차량이름이_중복이라면_예외를_던진다() {
    final Validator validator = new Validator();

    List<String> nameList = List.of("Steve", "Alex", "Steve");

    assertThatThrownBy( () -> validator.validName(nameList) )
        .isInstanceOf(RuntimeException.class);
  }

  @Test
  public void 시도횟수가_음수라면_예외를_던진다() {
    final Validator validator = new Validator();
    int round = -5;

    assertThatThrownBy( () -> validator.validRound(round))
        .isInstanceOf(RuntimeException.class);
  }

}
