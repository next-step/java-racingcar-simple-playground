package view;

import dto.CarProgressDto;
import dto.WinnersDto;

import java.util.List;

public class ConsoleOutputView implements OutputView {

    private static final String CAR_NAME_PROMPT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String ROUND_PROMPT = "시도할 회수는 몇회인가요?";
    private static final String RACING_RESULT_HEADER = "\n실행 결과";

    @Override
    public void printCarNamePrompt() {
        System.out.println(CAR_NAME_PROMPT);
    }

    @Override
    public void printRoundPrompt() {
        System.out.println(ROUND_PROMPT);
    }

    @Override
    public void printRacingResultMessageHeader() {
        System.out.println(RACING_RESULT_HEADER);
    }

    @Override
    public void printRoundResult(List<CarProgressDto> carResults) {
        for (CarProgressDto car : carResults) {
            System.out.println(car.toDisplayString());
        }
        System.out.println();
    }

    @Override
    public void printWinners(WinnersDto winnersDto) {
        System.out.println(winnersDto.toDisplayString());
    }
}
