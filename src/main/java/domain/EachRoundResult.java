package domain;

import java.util.ArrayList;
import java.util.List;

public class EachRoundResult {
    private List<List<Car>> positionSnapShot = new ArrayList<>();

    public void addSnapShot(List<Car> cars) {
        positionSnapShot.add(cars);
    }

    public List<Car> getSnapShot(int idx) {
        return positionSnapShot.get(idx);
    }

    public List<List<Car>> getWholeSnapShot() {
        return positionSnapShot;
    }

}
