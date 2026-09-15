# 자동차 경주 게임

## 게임 설명

n대의 자동차가 주어진 횟수만큼 이동하며 경주하는 게임.

- 각 자동차는 이름을 가진다.
- 매 라운드마다 0~9 사이의 랜덤 값을 구해서, 그 값이 4 이상이면 전진하고 3 이하면 멈춘다.
- 주어진 횟수만큼 라운드를 반복한 뒤, 가장 많이 전진한 자동차(들)이 우승자가 된다. 우승자는 한 명 이상일 수 있다.

## 진행 상황

- [x] 1단계 — 자동차 이동 기능 구현
- [x] 2단계 — 우승자 구하기 기능 구현

## 패키지 구조
````
src/main/java
├── Car.java
├── Cars.java
├── Race.java
├── CarMovement.java
├── RandomMovement.java
├── InputView.java
└── OutputView.java

src/test/java
├── CarTest.java
└── RaceTest.java
````
