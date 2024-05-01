package Model;

import Model.CarName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarNameTest {

    @DisplayName("이름이 공백값이면 오류가 난다.")
    @Test
    void NullNameTest(){
        assertThatThrownBy(()->{
            CarName carName = new CarName("   ");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("이름이 5글자를 초과하면 오류가 난다.")
    @Test
    void OverNameTest(){
        assertThatThrownBy(()->{
            CarName carName = new CarName("abcdef");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
