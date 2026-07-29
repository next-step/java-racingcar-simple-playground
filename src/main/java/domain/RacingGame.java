package domain;

import java.util.*;

public class RacingGame {

    private final List<RacingCar> cars = new ArrayList<>();
    private final Random random = new Random();

    public void init(String names[]) {
        for (String name: names) {
            cars.add(new RacingCar(name, 0));
        }
    }

    public void play() {
        for (int i = 0; i < cars.size(); i++) {
            int randomMove = random.nextInt(10);
            RacingCar racingCar = cars.get(i);
            racingCar.move(randomMove);
        }
    }

    private int updateMax (int max, List<String> winners, int i) {
        if (max > cars.get(i).getPosition()) {
            return max;
        }

        if (max < cars.get(i).getPosition()) {
            max = cars.get(i).getPosition();
            winners.clear();
        }

        winners.add(cars.get(i).getName());
        return max;
    }

    public List<String> winner() {
        int max = 0;
        List<String> winners = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            max = updateMax(max, winners, i);
        }

        return winners;
    }

    public List<RacingCar> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
