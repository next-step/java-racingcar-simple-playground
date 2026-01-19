public final class RacingCarGame {
    private final Race race;
    private final RandomNumberGenerator generator;
    private final OutputView outputView;

    public RacingCarGame(Race race, RandomNumberGenerator generator, OutputView outputView) {
        this.race = race;
        this.generator = generator;
        this.outputView = outputView;
    }

    public void play(int tryCount) {
        outputView.printStart();
        runAndPrint(tryCount);
        outputView.printWinners(race.cars().winnerNames());
    }

    private void runAndPrint(int tryCount) {
        for (int i = 0; i < tryCount; i++) {
            race.cars().moveAll(generator);
            outputView.printRound(race.cars().asList());
        }
    }
}