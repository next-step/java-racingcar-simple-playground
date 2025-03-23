import domain.Name;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class NameTest {

    @Test
    public void testCheckLength() {
        String name = "HYUNDAI";
        Assertions.assertThatThrownBy(() -> Name.checkLength(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void testCheckBlank() {
        String name = " ";
        Assertions.assertThatThrownBy(() -> Name.checkBlank(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
