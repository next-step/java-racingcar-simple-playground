package domain;

import java.util.List;

public interface Race {
    public void joinWithNames(List<String> names);

    public List<Participant> getParticipants();

    public void startOneRound();

    public List<String> getWinnerNames();
}
