package util;

public class InputValidation {

    public static String validateCarNames(String carNames) {
        if (carNames == null || carNames.isBlank()) {
            throw new RuntimeException("자동차 이름을 제대로 입력해주세요.");
        }
        return carNames;
    }

    public static int validateRunCount(String runCount) {
        if (runCount == null || runCount.isBlank()) {
            throw new RuntimeException("시도 횟수를 제대로 입력해주세요.");
        }
        int returnRunCount;
        try{
            returnRunCount = Integer.parseInt(runCount);
        }
        catch(NumberFormatException e){
            throw new RuntimeException("시도 횟수는 정수만 가능합니다.");
        }
        if (returnRunCount <= 0) {
            throw new RuntimeException("시도 횟수를 제대로 입력해주세요.");
        }
        return returnRunCount;
    }
}
