# 자동차 경주 게임

## 게임 설명

n대의 자동차가 주어진 횟수만큼 이동하며 경주하는 게임.

- 각 자동차는 이름을 가진다.
- 매 라운드마다 0~9 사이의 랜덤 값을 구해서, 그 값이 4 이상이면 전진하고 3 이하면 멈춘다.
- 주어진 횟수만큼 라운드를 반복한 뒤, 가장 많이 전진한 자동차(들)이 우승자가 된다. 우승자는 한 명 이상일 수 있다.

1. 입력을 받는다.
   1. 사용자는 자동차의 이름을 입력한다.
   2. 각 자동차는 이름을 가진다.
   3. 이름은 쉼표를 통해 구분되어 입력된다.
   4. 이름은 5자 이하만 가능하다. 
   5. 사용자는 몇 번의 이동을 하는 지 입력한다.
2. 자동차는 전진 또는 멈출 수 있다.
    1. 0-9 사이 랜덤 값을 구한다
    2. 랜덤값이 4 이상일 경우 전진한다.
    3. 랜덤값이 3 이하인 경우 멈춘다.
3. 자동차 경주 게임을 진행한다.
    1. 사용자가 입력한 이동 횟수 동안 전체 자동차를 순회한다.
    2. 한 자동차마다 전진, 정지 여부를 결정한다.
4. 우승자를 구한다.
    1. 전체 자동차를 순회하여 가장 큰 이동거리를 구한다.
    2. 가장 큰 이동거리와 이동거리가 같은 자동차를 모은다.
5. 우승자 자동차 리스트를 출력한다.
   1. 우승자가 한 명일 때, 한 명 출력한다.
   2. 우승자가 한 명 이상일 때 한 명 이상 출력한다.
   3. 출력 형식을 다음과 같이 한다. name : -(이동 거리만큼 "-" 입력)

## 패키지 구조
````
src/main/java
├── domain.Car.java
├── domain.Race.java
├── domain.Cars.java
├── domain.CarName.java
├── domain.Position.java
├── domain.movement.CarMovement.java
├── domain.movement.RandomMovement.java
├── view.InputView.java
└── view.OutputView.java

src/test/java
├── FixedMovement.java 
├── CarTest.java
├── CarsTest.java
├── CarName.java
├── PositionTest.java
└── RaceTest.java
````
