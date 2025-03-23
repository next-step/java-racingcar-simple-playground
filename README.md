# 🏎️ 자동차 경주
---
> 이 프로젝트는 자동차 경주 게임을 구현한 것입니다. 여러 대의 자동차가 주어진 횟수만큼 경주를 진행하고, 각 자동차는 랜덤 값에 따라 전진하거나 멈추게 됩니다. 경주가 끝난 후, 가장 앞에 있는 자동차가 승리합니다.
---
## 🚀 기능
- 사용자로부터 경주할 자동차의 이름과 라운드 수를 입력받습니다.
  - 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능합니다.
- 각 자동차의 이동 방식은 다음과 같습니다.
  - 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춥니다.
- 주어진 라운드 수만큼 게임이 진행되면서 각 라운드의 상황이 콘솔에 출력됩니다.
- 게임이 완료된 후, 어떤 자동차가 우승했는지 알 수 있습니다. 이때, 우승자는 한 대 이상일 수 있습니다.
---
## 🗃️ 프로젝트 구조
```
📁 src
│
├── 📁 main
│   └── 📁 java
│       ├── 📁 application
│       │   └── 📄 application.RacingCarApplication.java
│       ├── 📁 domain
│       │   ├── 📄 Car.java
│       │   ├── 📄 Cars.java
│       │   ├── 📄 MovingStrategy.java
│       │   ├── 📄 Racing.java
│       │   └── 📄 RandomMovingStrategy.java
│       └── 📁 view
│           ├── 📄 InputView.java
│           └── 📄 OutputView.java
│
└── 📁 test
    └── 📁 java
        └── 📁 domain
            ├── 📄 CarTest.java
            ├── 📄 RacingTest.java
            └── 📄 RandomMovingStrategyTest.java
```
---
## 💬 주요 클래스
- **application.RacingCarApplication**: 메인 애플리케이션 클래스로 사용자 입력을 받고 경주를 시작합니다.
- **Car**: 자동차 객체를 관리하는 클래스로 자동차의 이름과 위치를 저장합니다.
- **Cars**: 여러 대의 자동차를 관리합니다.
- **Racing**: 경주를 시작하고, 각 라운드마다 경주를 진행하며, 최종 우승자를 결정합니다.
- **MovingStrategy**: 자동차의 전진 여부를 결정하는 인터페이스입니다.
- **NumberGenerator**: 난수 생성기를 제공하는 인터페이스입니다.
---
## ⏯️ 실행 방법

### 1. `application.RacingCarApplication` 클래스 실행

`application.RacingCarApplication` 클래스의 `main` 메서드를 실행하여 게임을 시작합니다.

### 2. 게임 진행

- 게임이 시작되면, 콘솔에 자동차의 이름을 입력하고 경주할 라운드 수를 입력합니다.
- 각 라운드가 진행될 때마다 각 자동차의 전진 여부가 결정되고, 결과가 출력됩니다.
- 경주가 끝난 후 최종 우승자가 출력됩니다.
