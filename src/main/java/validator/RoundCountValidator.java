package validator;

public class RoundCountValidator {
    public static void validate(int roundCount) {
        if (roundCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 1회 이상으로 입력해 주세요.");
        }
    }
}
