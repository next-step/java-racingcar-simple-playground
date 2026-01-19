java-racingcar
================

## 1. 요구사항
### 1.1 움직이는 자동차
- 자동차는 이름을 가지고 있다.
- 자동차는 움직일 수 있다. 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차가 움직이는 기능이 의도대로 동작하는지 테스트한다.

### 1.2 우승 자동차 구하기
- n대의 자동차가 참여할 수 있다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 구할 수 있다. 우승자는 한 명 이상일 수 있다.
- 우승자를 구하는 기능이 의도대로 동작하는지 테스트한다.

### 1.3 게임실행
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 메인 메서드를 추가하여 실행 가능한 애플리케이션으로 만든다.

## 2. 구현 요약
### 2.1 움직이는 자동차
- `Car`
  - 필드: `name(String)`, `position(int)`
  - 동작: `move(RandomNumberGenerator generator)`에서 `generator.generate()` 결과가 `4` 이상이면 `position++`
- `RandomNumberGenerator` / `RandomNumberGeneratorImpl`
  - `ge의nerate()`는 `0~9` 범위 값을 반환 (`new Random().nextInt(10)`)
- 테스트
  - 랜덤값 생성처리를 어떻게 해야할지 모르기때문에, `FixedNumberGenerator` 로 고정값을 주입해 규칙을 검증 (고민필요)


### 2.2 우승 자동차 구하기
- `Cars`
  - 여러 대의 `Car`를 보유
  - `moveAll(generator)`: 모든 자동차가 1회씩 `move()` 수행
  - `winnerNames()`: 가장 큰 `position`을 가진 자동차 이름들을 반환
- `Race`
  - `run(tryCount, generator)`: `tryCount`만큼 라운드를 반복하며 `cars.moveAll(generator)` 수행

### 2.3 게임실행
- 입력/출력
  - `InputView`: 자동차 이름 입력과 시도 횟수 입력
  - `OutputView`: 라운드별 결과 출력, 최종 우승자 출력
- 파싱/검증
  - `CarNamesParser`: `,`를 파싱하여 `List<Car>`로 변환
  - `CarName`: 이름 5자 이하와 빈 값 금지
  - `Car`는 `CarName`로 이름 규칙을 보장
- `RacingCarGame` (service/controller 역할)
  - `tryCount`만큼 라운드 진행
  - 매 라운드마다 `cars.moveAll(generator)` 후 `OutputView`로 상태 출력
  - 종료 후 `cars.winnerNames()` 결과를 출력


## 3. 예외사항
- 자동차 이름은 빈값이거나 공백으로만 구성될 수 없다.
- 자동차 이름은5자 이하만 가능하다.
- 시도횟수는 0이거나 숫자가 아닌값을 입력해서는 안된다.

## 4. 질문
- test할때, 고정된 값을 만들어서 test를 진행했는데, test에 매 라운드마다 랜덤한 값을 만들어서 적용할 수 있나요?
- VIEW의 input과 output에 대한 단위테스트도 진행해야하나요?