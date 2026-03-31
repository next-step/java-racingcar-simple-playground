package view.applicationIOManager;

public class UserInput {
    private String[] participants;
    private int attempt;

    public UserInput(String[] participants, int attempt) {
        this.attempt = attempt;
        this.participants = participants;
    }

    public UserInput() {
    }

    public void setParticipants(String[] participants) {
        this.participants = participants;
    }

    public String[] getParticipants() {
        return participants;
    }

    public void setAttempt(int attempt) {
        this.attempt = attempt;
    }

    public int getAttempt() {
        return attempt;
    }
}
