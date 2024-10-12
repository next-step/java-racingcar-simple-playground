import domain.Car;
import domain.CarParser;
import domain.Race;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ExceptionHandlingTest {

    @Test
    void 자동차_이름_입력_예외처리() {
        assertAll(
                // 5자가 넘어가면 예외처리
                () -> assertThatCode(() -> CarParser.parsing("123,1234,12345,123456"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("올바르지 않은 자동차 이름입니다."),
                // 쉼표가 아닌 다른 문자로 구분 시 예외처리
                () -> assertThatCode(() -> CarParser.parsing("123;1234,12345"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("올바르지 않은 입력 형식입니다."),
                // 공백에 포함되어 있을 때 예외처리
                () -> assertThatCode(() -> CarParser.parsing("123, 1234,12345"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("올바르지 않은 입력 형식입니다."),
                // 구분자가 여러 번 입력되었을 때 예외처리
                () -> assertThatCode(() -> CarParser.parsing("123,,1234,12345"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("올바르지 않은 자동차 이름입니다."),
                // 중복된 자동차 이름이 입력되었을 때 에외처리
                () -> assertThatCode(() -> CarParser.parsing("123,123,1234"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("중복된 자동차 이름은 입력될 수 없습니다.")
        );
    }

    @Test
    void 레이스_객체_생성_예외처리() {
        assertAll(
                // 자동차가 두 대 이상이 아니면 Race 생성 불가
                () -> assertThatCode(() -> Race.createRace(
                        List.of(new Car("test1")), 2))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("두 대 이상의 차를 입력해주세요."),

                // 시도 횟수가 0회 이하이면 Race 생성 불가
                () -> assertThatCode(() -> Race.createRace(
                        List.of(new Car("test1"), new Car("test2")), 0))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("1번 이상의 시도횟수를 입력해주세요.")
        );
    }
}
