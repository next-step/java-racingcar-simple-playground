package view;

import java.util.List;

import static domain.Utils.checkSizeOfArray;

public class OutputView {
    private void printOneMove(final int[] movedDistance, final String[] names) {
        checkSizeOfArray(movedDistance, names.length);
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " : " + "-".repeat(movedDistance[i]));
        }
        System.out.println();
    }

    private int[] getMovedDistance(final List<List<Integer>> moveHistories, final int step) {
        final int[] movedDistance = new int[moveHistories.size()];
        for (int i = 0; i < moveHistories.size(); i++) {
            movedDistance[i] = moveHistories.get(i).subList(0, step).stream().reduce(0, Integer::sum); //Arrays.stream(moveHistories.get(i), 0, step).sum();
        }
        return movedDistance;
    }

    public void printRaceResult(final List<List<Integer>> moveHistories, final String[] names, final List<String> winners) {
        System.out.println("실행 결과");
        for (int i = 0; i < moveHistories.get(0).size(); i++) {
            printOneMove(getMovedDistance(moveHistories, i + 1), names);
        }
        System.out.print(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
