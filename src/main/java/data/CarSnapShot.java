package data;

import java.util.Objects;

public class CarSnapShot {
    private final String carName;
    private final int distance;

    public CarSnapShot(String carName, int distance) {
        this.carName = carName;
        this.distance = distance;
    }

    public String getCarName() {
        return carName;
    }

    public int getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarSnapShot that)) return false;
        return getDistance() == that.getDistance() && Objects.equals(getCarName(), that.getCarName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarName(), getDistance());
    }
}
