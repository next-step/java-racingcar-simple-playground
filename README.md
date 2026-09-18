# 🚗 자동차 경주 게임

Java로 구현한 자동차 경주 게임입니다.

자동차 이름과 경주 횟수를 입력받고, random 값에 따라 자동차를 전진시키며 경주를 n번 진행합니다.
자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능합니다.
0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춥니다.
경주가 끝난 후 가장 멀리 이동한 자동차를 최종 우승자로 출력합니다. 우승자는 한 명 이상일 수 있습니다.

## 📁 프로젝트 구조

```text
src
├── main
│   └── java
│       ├── Car.java
│       ├── Cars.java
│       ├── Race.java
│       ├── CarRaceMain.java
│       └── NumberGenerator
│           ├── NumberGenerator.java
│           └── RandomNumberGenerator.java
│           
└── test
    └── java
        ├── FixNumberGenerator.java
        └── CarRaceTest.java
