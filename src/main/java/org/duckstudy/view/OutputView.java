package org.duckstudy.view;

public class OutputView {

    public void printInputCarNamesMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
    }

    public void printInputRepetitionNumMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultStartMessage() {
        System.out.println("\n실행 결과");
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printWinnerNames(String winnerNames) {
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }

    public void printException(Exception e) {
        System.out.println(e.getMessage());
    }
}
