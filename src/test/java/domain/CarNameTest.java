package domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {

    @Test
    void 정상적인_이름이면_생성된다() {
        CarName carName = new CarName("car1");
        assertEquals("car1", carName.getCarName());
    }

    @Test
    void null이나공백이면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new CarName(null));
        assertThrows(IllegalArgumentException.class, () -> new CarName("   "));
    }

    @Test
    void 다섯글자를_초과하면_예외가_발생한다() {
        assertThrows(IllegalArgumentException.class, () -> new CarName("aaaaaa"));
    }
}
