public class Car {
    String name; //자동차 이름
    int distance; //자동차가 현재 어디에 있는지
    RandomNumberGenerator numberGenerator;

    Car(String name, int distance, RandomNumberGenerator numberGenerator) {
        this.name = name;
        this.distance = distance;
        this.numberGenerator = numberGenerator;
    }

    /**
     랜덤 생성해서 필드값 움직여줌
     */
    public int moving() {
        int random = numberGenerator.createRandomNumber();
        if (random >= 4) {
            distance++;
            return distance;
        }
        return distance;
    }
}
