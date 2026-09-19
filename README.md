# 자동차 경주 게임 (Car Racing Game)

## 프로젝트 개요

콘솔에서 실행되는 자동차 경주 게임입니다.
자동차 이름을 입력받아 여러 대의 자동차 객체를 생성하고, 입력한 횟수만큼 라운드를 진행하며 각 자동차가 무작위 값에 따라 전진하거나 멈춥니다. 모든 라운드가 끝나면 가장 멀리 이동한 자동차(들)이 우승자로
선정됩니다.

## 게임 규칙

- 자동차 이름은 쉼표(,)로 구분해서 여러 대를 한 번에 입력받습니다.
- 자동차 이름은 5자를 초과할 수 없습니다.
- 0~9 사이의 랜덤 값을 구해, 4 이상이면 전진하고 3 이하면 멈춥니다.
- 사용자가 입력한 횟수만큼 라운드를 반복하며, 매 라운드마다 각 자동차의 위치를 출력합니다.
- 가장 멀리 이동한 자동차가 우승자이며, 공동 우승자가 나올 수 있습니다.

## 패키지 / 클래스 구조

```
Application.java              # 입력/출력을 조립하는 실행 진입점(main 메서드)

domain
├── Car.java                  # 이름과 위치를 가지며, 4 이상이면 전진
├── Cars.java                 # n대의 Car를 리스트로 관리, 이름 배열로 Cars를 생성하는 정적 팩토리(createCars) 포함
├── RandomNumber.java         # 랜덤 값 생성 인터페이스
├── DefaultRandomNumber.java  # RandomNumber의 실제 구현체 (0~9 사이 랜덤 값)
└── RacingGame.java           # 한 라운드씩 경주를 진행

view
├── InputView.java            # 자동차 이름/시도 횟수 입력받기
└── ResultView.java           # 라운드별 진행 상황, 최종 우승자 출력

test/domain
├── CarTest.java              # 전진/정지, 이름 검증(null/blank/5자 초과) 테스트
├── CarsTest.java             # 이동, 우승자 판별, 이름 배열로 생성하는 로직 테스트
└── FixedRandomNumber.java    # 테스트용 고정값 RandomNumber 구현체
```
