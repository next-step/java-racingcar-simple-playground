package domain;

public class Car {
    private final String name;
    private int totalDistance = 0;
    private final NumberGenerator numberGenerator;

    public Car(String name, NumberGenerator numberGenerator) {
        validateName(name);
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public String getName() {
        return name;
    }

    /*
    * 이름 길이가 5자 이하인지 검사
    * */
    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    /*
    * 자동차가 움직일지, 멈출지 검사
    * */
    public boolean isMove(int ranVal) {
        return ranVal >= 4;
    }

    /*
    * 자동차를 움직이는 메서드
    * */
    public void move() {
        if (isMove(numberGenerator.getNumber())) {
            totalDistance++;
        }
    }

    /*
    * 누적 이동거리 반환
    * */
    public int getTotalDistance() {
        return this.totalDistance;
    }
}

