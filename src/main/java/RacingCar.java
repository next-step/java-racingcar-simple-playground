public class RacingCar {
    private final String carName;
    public int numOfForward = 0;
    RacingCar(String carName){
        if(carName == null || carName.isEmpty()) throw new RuntimeException("제대로된 자동차 이름을 입력해주세요.");
        if(carName.length() > 5) throw new RuntimeException("자동차 이름은 5자 이하로 설정해주세요.");
        this.carName = carName;
    }
}
