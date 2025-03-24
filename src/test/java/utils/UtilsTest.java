package utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class UtilsTest {

    @Test
    void 쉼표로_연결된_문장은_쉼표로_나누어_문자열_리스트로_반환해야한다() {
        String string = "기아,현대,쌍용";
        List<String> strings = Utils.splitByDelimiter(string, ",");
        assertThat(strings.size()).isEqualTo(3);
    }

}
