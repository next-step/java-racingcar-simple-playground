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
            throw new RuntimeException("이름이 비어있습니다.");
    }

    public void validNameSize(String name) {
        if (name.length() > 5)
            throw new RuntimeException("이름의 길이가 5자를 넘었습니다.");
    }

    public void validParseTimes(String strTimes) {
        try {
            Integer.parseInt(strTimes);
        } catch (NumberFormatException ex) {
            throw new RuntimeException("정수가 아닌 값이 입력되었습니다.");
        }
    }

    public void validTimesRange(int times) {
        if (times < 0) {
            throw new RuntimeException("시도 횟수에 음수가 입력되었습니다.");
        }
    }
}
