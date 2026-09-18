public class CarName {
    private static final int MAX_LENGTH = 5;
    private final String value;

    public CarName(String value) {
        if(value.isEmpty()){
            throw new IllegalArgumentException("이름은 비어있을 수 없습니다.");
        }
        if(value.length() > MAX_LENGTH){
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
