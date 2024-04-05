# 3단계 기능명세서

## 기능 요구사항
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

## 추가된 요구사항
- **메인 메서드를 추가**하여 실행 가능한 애플리케이션으로 만든다.

## 기능 명세서
1. [x] 자동차 이름(`name`)이 6자 이상일 때, 생성이 되면 안된다.
2. [x] `main` 메서드를 통해 자동차 이름과 횟수를 입력할 수 있어야 한다.
   3. [x] 입력한 자동차 이름의 개수만큼 자동차가 생성되어야 한다.
   4. [x] 입력한 횟수만큼 레이싱 게임이 반복되어야 한다.
5. [x] 차량은 전진할 때, 이동한 거리(`-`)가 출력되어야 한다.
6. [x] 게임과 관련된 메시지를 출력하는 역할을 별도로 구분한다.

## 추가로 구현할 내용
1. [x] 자동차 이름이 중복될 때, 예외를 발생해야 한다.
   - Validator를 추가로 구현한 후, Parser 객체에서 사용하도록 리팩토링
2. [x] 입력된 게임 횟수가 1보다 작을 경우, 예외를 발생해야 한다.

### 실행결과
```java
경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).
neo,brie,brown
시도할 회수는 몇회인가요?
5

실행 결과
neo : -
brie : -
brown : -

neo : --
brie : -
brown : --

neo : ---
brie : --
brown : ---

neo : ----
brie : ---
brown : ----

neo : -----
brie : ----
brown : -----

neo : -----
brie : ----
brown : -----

neo, brown가 최종 우승했습니다.
```

## 제출 전 체크
- [x] 클래스 별 코드 위아래 공백 확인
- [x] 기존 프로그래밍 요구사항 준수하는지 확인

## 추가로 학습할 것
- [ ] 커스텀 예외

## 과제를 수행하면서 배운 점
### 테스트
1. `@ParameterizedTest`와 `@Test`를 같이 쓰면 에러가 발생한다.

# 4단계 기능명세서
