package domain;

public class Play {
    private final Cars cars;
    private final NumberGenerator numberGenerator;

    public Play(Cars cars, NumberGenerator numberGenerator) {
        this.cars = cars;
        this.numberGenerator = numberGenerator;
    }

    public void playRound() {
        for (int i = 0; i < cars.size(); i++) { //라운드의 플레이 하나
            int presentNum = numberGenerator.generate();
            setState(presentNum, i);
        }
    }

    private void setState(int num, int i) {
        cars.get(i).move(num);
    }
}
