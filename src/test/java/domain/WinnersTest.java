package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinnersTest {
    @Test
    void 우승자를설정할수있다() {
        // given,when
        Winners winners = Winners.of(Arrays.asList("car1", "car2"));

        // then
        List<String> result = winners.getWinners();
        assertEquals(2, result.size());
        assertEquals("car1", result.get(0));
        assertEquals("car2", result.get(1));
    }
}
