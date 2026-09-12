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
├── CarMovement.java
├── RandomMovement.java
├── CarList.java
├── InputView.java
└── OutputView.java

src/test/java
├── CarTest.java
├── CarListTest.java
├── AlwaysMovable.java
└── NeverMovable.java
````

## 설계 포인트

- **판단과 이동의 분리**: `Car`는 랜덤값을 직접 다루지 않고, "이동 가능한지" 여부(`boolean`)만 받아서 위치를 바꾼다. 판단 로직은 `CarMovement` 인터페이스로 분리되어 있어, 테스트 시 랜덤 없이 `AlwaysMovable`/`NeverMovable` 같은 고정된 결과를 주입해 검증할 수 있다.
- **책임 분리**: 자동차 한 대(`Car`)는 자기 이름·위치와 이동 여부만 책임지고, 여러 대를 관리하고 우승자를 찾는 일은 `CarList`가 담당한다.