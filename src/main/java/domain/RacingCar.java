package domain;

import java.util.*;

public class RacingCar {

    public HashMap<String, Integer> car = new HashMap<>();
    Random random = new Random();

    public int moveReturn(int randomMove) {
        if (randomMove >= 4) {
            return 1;
        }
        return 0;
    }

    public void move(String carName, int randomMove) {
        if (moveReturn(randomMove) == 1) {
            car.put(carName, car.get(carName) + 1);
        }
    }

    public void init(String[] names) {
        for (int i = 0; i < names.length; i++) {
            car.put(names[i], 0);
        }
    }

    public void play(String[] names) {

        for (Map.Entry<String, Integer> entry : car.entrySet()) {
            int randomMove = random.nextInt(10);
            move(entry.getKey(), randomMove);
        }
    }

    public List<String> winner() {

        car.put("car123", 0);
        int max = car.get("car123");

        List<String> winners = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : car.entrySet()) {

            if (max < entry.getValue()) {
                max = entry.getValue();
                winners.clear();
                winners.add(entry.getKey());
            }

            else if (max == entry.getValue()) {
                winners.add(entry.getKey());
            }
        }

        return winners;
    }
}