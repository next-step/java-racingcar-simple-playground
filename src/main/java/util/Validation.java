package util;

public class Validation {

    public void validName(String name) throws RuntimeException {
        validNameIsNullOrBlank(name);
        validNameSize(name);
    }

    public void validTimes(String strTimes) throws RuntimeException {
        validParseTimes(strTimes);
        validTimesRange(Integer.parseInt(strTimes));

    }

    public void validNameIsNullOrBlank(String name) {
        if (name == null || name.isBlank())
            throw new IllegalArgumentException("이름에 공백이 포함되었습니다.");
    }

    public void validNameSize(String name) {
        if (name.length() > 5)
            throw new IllegalArgumentException("이름의 길이가 5자를 넘었습니다.");
    }

    public void validParseTimes(String strTimes) {
        try {
            Integer.parseInt(strTimes);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 아닌 값이 입력되었습니다.");
        }
    }

    public void validTimesRange(int times) {
        if (times < 0) {
            throw new IllegalArgumentException("시도 횟수에 음수가 입력되었습니다.");
        }
    }
}
