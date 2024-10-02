package domain;

import org.assertj.core.api.Assert;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarNameTest {
    @Test
    @DisplayName("이름 길이 테스트")
    void carNameTest(){
        CarName carName = new CarName("Test");
        String name = carName.getName();
        Assertions.assertThat(name.length()).isBetween(1,6);
    }

    @Test
    @DisplayName("이름이 비어있을때 예외 발생 테스트")
    void carNameEmptyTest() {
        Assertions.assertThatThrownBy(() -> new CarName(""))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이름을 입력하세요.");
    }

    @Test
    @DisplayName("이름이 너무 길때 예외 발생 테스트")
    void carNameLongTest() {
        Assertions.assertThatThrownBy(() -> new CarName("namename"))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("이름은 5자 이하입니다.");
    }

}