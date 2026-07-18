package domain;

public class Car {
    private final String name; // 자동차의 이름
    private int totalDistance = 0; // 이동한 누적 거리, 초기값은 0


    // 리펙토링: 랜덤값은 numberGenerator를 구현하여 구함
    // 테스트 시에는 테스트용 메서드를 구현하여 사용할 예정
    private final NumberGenerator numberGenerator;


    // 생성자에서 랜덤 생성기를 받음,
    public Car(String name, NumberGenerator numberGenerator) {
        validateName(name);
        this.name = name;
        this.numberGenerator = numberGenerator;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    // 자동차가 움직일지, 멈출지 검사하는 메서드
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

    // 누적 이동거리 반환하는 메서드
    public int getTotalDistance() {
        return this.totalDistance;
    }
}

