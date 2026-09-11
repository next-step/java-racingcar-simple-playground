public class Car {
    // 자동차 이름 멤버변수
    private String name;
    // 자동차 위치 멤버변수
    private int pos;
    
    // 생성자 - 자동차 이름 설정, 위치 0으로 설정
    public Car(String name) {
        this.name = name;
        pos = 0;
    }
    // 자동차 움직이는 메서드
        // 난수 생성 메서드
        // 생성한 랜덤 값을 이용해서 움직일지 말지 결정하는 메서드
        // 움직일지 말지 결정된거를 이용해서 자동차 위치 변경
    public void moveCar() {
        if (shouldMove(makeRandomNum())) pos++;
    }
    private int makeRandomNum() {
        return (int)(Math.random() * 10);
    }
    private boolean shouldMove(int randomNum) {
        if (randomNum >= 4) return true;
        return false;
    }
}
