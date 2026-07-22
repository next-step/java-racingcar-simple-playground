package domain;

@FunctionalInterface // 추상 메서드가 하나만 있는 인터페이스
public interface NumberGenerator {

    int generate(); // 숫자 생성하는 객체가 지켜야 하는 규칙
}