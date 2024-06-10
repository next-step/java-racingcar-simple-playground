package util;

public interface NumberGenerator {
    int generateNum();

    default void rangeCheck(int num){
        if(num <0 || num > 9){
            throw new IllegalArgumentException("숫자는 0부터 9사이 입니다.");
        }
    }
}
