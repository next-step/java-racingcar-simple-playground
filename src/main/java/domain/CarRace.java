package domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CarRace {

    public int generateRandom0to9() {
        return (int) (Math.random() * 10);
    }

    public void checkMove(int move) {
        if (move < 0 || move > 9) {
            throw new RuntimeException("move 값이 적절한 범위를 벗어남.");
        }
    }

    public int determineMoveDistance(int move) {
        if (move >= 4) {
            return 1;
        }
        return 0;
    }

    public void playRound(int[] carscores) {
        for (int i = 0; i < carscores.length; i++) {
            int move = generateRandom0to9();
            checkMove(move);
            carscores[i] += determineMoveDistance(move);
        }
    }

    public String getWinners(int[] carscores, String[] carnames) {
        int maxScore = IntStream.of(carscores).max().orElse(0);
        return IntStream.range(0, carscores.length)
                .filter(i -> carscores[i] == maxScore)
                .mapToObj(i -> carnames[i])
                .collect(Collectors.joining(", "));
    }

    public String getTrace(int carscore) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < carscore; i++) {
            sb.append("-");
        }
        return sb.toString();
    }

    public void validateCarNames(String[] carnames) {
        for (String name : carnames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다: " + name);
            }
        }
    }


}
