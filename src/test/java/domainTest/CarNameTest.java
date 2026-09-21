package domainTest;

import domain.Car;
import domain.CarName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarNameTest {
    @Test
    @DisplayName("이름이 5자일 때 오류가 발생하지 않는다.")
    void SafeWhenNameIsFiveWords() {
        CarName carName = new CarName("ABCDE");
        assertEquals("ABCDE", carName.getValue());
    }

    @Test
    @DisplayName("이름이 5자 초과일 때 오류가 발생한다.")
    void errorWhenNameMoreFiveWords() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new CarName("ABCDEF")
        );
        assertEquals("이름은 5자 이하여야 합니다.", exception.getMessage());
    }

    @Test
    @DisplayName("이름이 비어있을 때 오류가 발생한다.")
    void errorWhenNameEmpty() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new CarName(""));
        assertEquals("이름은 비어있을 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("이름이 공백일 때 오류가 발생한다.")
    void errorWhenNameBlank() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new CarName(" "));
        assertEquals("이름은 비어있을 수 없습니다.", exception.getMessage());
    }

    @Test
    @DisplayName("이름이 NULL일 때 오류가 발생한다.")
    void errorWhenNameNULL() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> new CarName(null));
        assertEquals("이름은 비어있을 수 없습니다.", exception.getMessage());
    }
}
