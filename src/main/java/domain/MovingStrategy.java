package domain;

@FunctionalInterface
public interface MovingStrategy {

    // 자동차가 전진할 수 있는지 여부 판단
    boolean isMovable();
}
