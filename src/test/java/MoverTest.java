import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class MoverTest {

    @Test
    @DisplayName("4이상의 숫자가 나올 경우 1 반환")
    void return_1() {
        Mover mover = new Mover();
        assertThat(mover.move(4)).isEqualTo(1);
        assertThat(mover.move(9)).isEqualTo(1);
    }

    @Test
    @DisplayName("3이하의 숫자가 나올 경우 0 반환")
    void return_0() {
        Mover mover = new Mover();
        assertThat(mover.move(3)).isEqualTo(0);
    }
}
