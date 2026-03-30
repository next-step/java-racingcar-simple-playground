# 자동차 경주 애플리케이션

간단한 콘솔 애플리케이션을 구현합니다.

## 기능 명세서

### 자동차 [`Car`](src/main/java/racingcar/domain/Car.java)

- 길이가 5자 이하인 이름을 가지고 있다: [`Car.Name`](src/main/java/racingcar/domain/Car.java)
- 정수로 된 위치를 가지고 있다: [`Movable`](src/main/java/racingcar/domain/Movable.java).[
  `position`](src/main/java/racingcar/domain/Position.java)
- 자동차를 둘러싼 환경이 정의된다: [`Environment`](src/main/java/racingcar/domain/Environment.java)
- 한번 움직이려고 할 때마다,
    * 6/10 확률로 장애물을 회피할 수 있다: [`ObstaclesAhead`](src/main/java/racingcar/domain/ObstaclesAhead.java)
    * 장애물을 회피할 경우 1칸 전진한다. 그렇지 않다면 전진하지 않는다.
    * 너무 많이 전진하여, 위치가 `Integer.MAX_VALUE`에서 더 나아간다면 예외를 발생시킨다.

### 자동차 경주 [`CarRacing`](src/main/java/racingcar/domain/CarRacing.java)

- n대의 자동차가 참여할 수 있다.
- 게임의 횟수를 입력받는다.
- 매 회차마다 모든 자동차들은 전진 또는 멈출 수 있다.
    * 전진을 하는지 여부는 위의 자동차에서 정의된 대로 한다.
- 경주 게임을 완료한 후, 누가 우승했는지를 구한다. 우승자는 한 명 이상일 수 있다.

### 메인 애플리케이션 [`ApplicationController`](src/main/java/racingcar/controller/console/ApplicationController.java)

뷰 입력을 통해서 콘솔(stdin)에서 받아온 정보를 도메인에 전달하며, 결과를 메인 뷰를 통해 콘솔(stdout)으로 내보낸다.

- 컨트롤러(stdin) -> 뷰 입력 -> 도메인 -> 뷰 출력 -> 컨트롤러(stdout)

### 메인 뷰 [`ApplicationView`](src/main/java/racingcar/view/text/ApplicationView.java), 뷰 입력 [`ViewInput`](src/main/java/racingcar/view/text/ViewInput.java)

텍스트로 된 입력을 읽과, 텍스트로 정보를 표시한다.

1. 경주할 자동차의 이름을 입력받는다. 이름은 `Car.Name`의 조건을 똑같이 따른다. 각 이름은 쉼표(,)를 기준으로 구분되며, 이름 앞뒤에 여백이 있을
   경우 자를 수 있다.
2. 시도할 횟수를 정수로 받는다.
3. 매 회차 실행한 결과 자동차의 위치를 출력한다.
4. 최종 우승한 자동차의 이름을 출력한다.
