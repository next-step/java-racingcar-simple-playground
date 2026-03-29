package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class CarTest {

    @DisplayName("luck이 4이상이면 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = { 4, 5, 6, 7, 8, 9 })
    void moveForwardGoodLuckTest(int luck) {
        //given
        Participant participant = new Car("Good");
        int distance = participant.getDistance();
        //when
        participant.moveForward(luck);
        //then
        Assertions.assertThat(participant.getDistance()).isEqualTo(distance + 1);
    }

    @DisplayName("luck이 4미만이면 움직이지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = { 3, 2, 1, 0 })
    void moveForwardBadLuckTest(int luck) {
        //given
        Participant participant = new Car("Bad");
        int distance = participant.getDistance();
        //when
        participant.moveForward(luck);
        //then
        Assertions.assertThat(participant.getDistance()).isEqualTo(distance);
    }
}
