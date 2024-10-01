import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestRacingContest {
  private static int round;
  private static RacingContest contest;
  private static final String[] names = new String[]{"neo", "brie", "brown"};

  @BeforeAll
  public static void setUp() {
    RacingCar[] participants = new RacingCar[]{
        new RacingCar(names[0]),
        new RacingCar(names[1]),
        new RacingCar(names[2])
    };
    round = 10;
    contest = new RacingContest(participants, round);
  }

  @Test
  @DisplayName("경기 결과 모든 차의 주행거리가 0 이상이고 주어진 횟수 round 이하인지 확인")
  public void testStart() {
    //given
    int round = contest.getRounds();

    //when
    int[] distances = contest.start();
    int maxDist = Arrays.stream(distances).max().getAsInt();
    int minDist = Arrays.stream(distances).min().getAsInt();

    //then
    assertThat(maxDist).isBetween(0, round + 1);
    assertThat(minDist).isBetween(0, round + 1);
  }
  @Test
  @DisplayName("경기 결과를 바탕으로 우승자를 가려낼 수 있는지 확인")
  public void testRanking() {
    //given
    int[] distances = new int[]{0, round, round};
    String[] winners = new String[]{names[1], names[2]};

    //when
    ArrayList<String> actual = contest.ranking(distances);
    ArrayList<String> expected = new ArrayList<>(Arrays.asList(winners));

    //then
    assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
  }
}
