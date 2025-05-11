import java.util.List;

public class RacingCarCheck {
    private static final int MAX_NAME_LENGTH = 5;


    public static void checkCarName(List<String> racingCarName) {
        racingCarName.stream()
                .map(String::strip)
                .forEach(name -> {
                    if (name.length() > 5) {
                        throw new IllegalArgumentException("자동차의 이름은 5자 이하로 작성해주세요" + name);
                    }
                });
    }
}
