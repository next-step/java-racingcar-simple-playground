import java.util.LinkedList;
import java.util.List;

public class FixedNumberGenerator implements NumberGenerator {

  private Integer result;
  private final List<Integer> queue = new LinkedList<>();

  public FixedNumberGenerator(final Integer integer) {
    result = integer;
  }

  @Override
  public int getNumber() {
    return result;
  }
}
