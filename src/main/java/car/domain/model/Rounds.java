package car.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Rounds {

    private final List<Round> history = new ArrayList<>();
    private final int totalCount;

    public Rounds(int count) {
        this.totalCount = count;
    }

    public void addReport(Round round) {
        history.add(round);
    }

    public List<Round> getHistory() {
        return Collections.unmodifiableList(history);
    }

    public int getTotalCount() {
        return totalCount;
    }


}
