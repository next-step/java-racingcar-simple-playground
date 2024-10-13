import static org.assertj.core.api.Assertions.assertThat;

import domain.RacingCar;
import domain.RacingContest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestRacingContest {

  private static RacingContest contest;

  @BeforeAll
  public static void setUp() {
    int rounds = 5;
    List<String> playerNames = Arrays.asList("neo", "brie", "brown");
    contest = new RacingContest(playerNames, rounds);
  }

  @Test
  @DisplayName("경기 결과 모든 차의 주행거리가 0 이상이고 주어진 횟수 round 이하인지 확인")
  public void testStart() {
    //given
    int round = contest.getRounds();
    var distances = contest.getDistances();

    //when
    int maxDist = distances.values().stream().max(Integer::compareTo).get();
    int minDist = distances.values().stream().min(Integer::compareTo).get();

    //then
    assertThat(maxDist).isBetween(0, round + 1);
    assertThat(minDist).isBetween(0, round + 1);
  }
  @Test
  @DisplayName("경기 결과를 바탕으로 우승자를 가려낼 수 있는지 확인")
  public void testRanking() {
    //given
    contest.goRound();
    var distances = contest.getDistances();
    var winners = contest.getWinners();

    //when
    var actual = distances.get(winners.get(0));
    var expected = distances.values().stream().max(Integer::compareTo).get();

    //then
    assertThat(actual).isEqualTo(expected);
  }
}
