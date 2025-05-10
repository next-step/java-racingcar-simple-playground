package domain;

import java.util.Objects;
import java.util.UUID;

public class Car {
    private static final int INITIAL_POSITION = 0;

    private final UUID id;
    private final Name name;
    private Position position;

    public Car(Name name) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.position = new Position(INITIAL_POSITION);
    }

    public void move(MoveCondition condition) {
        if (condition.isMoveable()) {
            position = position.forward();
        }
    }

    public Name getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Car other)) return false;
        return id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
