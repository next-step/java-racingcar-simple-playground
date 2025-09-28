package domain;

import java.util.ArrayList;
import java.util.List;

public class Winners {
    private List<String> winners;

    private Winners(List<String> winners) {
        this.winners = List.copyOf(winners);
    }

    public static Winners of(List<String> winnerNames) {
        return new Winners(winnerNames);
    }

    public List<String> getWinners() {
        return winners;
    }

}

