


public class RacingController {
    public void run() {
        // 1. 입력 (View)
        String[] carNames = InputView.getCarNames();
        int raceCount = InputView.getRaceCount();

        // 2. 생성 (Model)
        Cars cars = new Cars(carNames);

        // 3. 실행 및 결과 출력 (Controller -> Model, Controller -> View)
        OutputView.printResultMessage();
        for (int i = 0; i < raceCount; i++) {
            cars.moveAll(); // Model의 상태 변경 요청
            OutputView.printRoundResult(cars.getCars()); // View에 출력 요청
        }

        // 4. 최종 결과 출력 (Controller -> Model, Controller -> View)
        OutputView.printWinners(cars.findWinners());
    }
}