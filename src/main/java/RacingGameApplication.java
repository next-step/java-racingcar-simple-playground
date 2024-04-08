public class RacingGameApplication {
    public static void main(String[] args) {
        RacingCarStep3 rcCar = new RacingCarStep3();
        rcCar.getCarNames(); // 참가 자동차 이름 입력
        rcCar.setN();        // 이름 입력 바탕으로 자동차 대수 n 초기화
        rcCar.getCnt();      // 횟수 cnt 입력
        rcCar.setCarLocations();
        rcCar.racingGame();  // 게임 실행
        rcCar.winnerChecking(); // 우승자 확인
        rcCar.winnerPrinting(); // 우승자 출력
    }
}
