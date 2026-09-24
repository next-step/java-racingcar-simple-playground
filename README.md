# 자동차 경주 과제

## 주요 기능

- 사용자는 전진 시도 횟수와 각 자동차의 이름을 입력할 수 있다.
- 각 자동차는 입력된 시도 횟수만큼 전진을 시도한다.
- 0~9 사이의 랜덤 값이 4 이상이면 전진하고, 3 이하이면 멈춘다.
- 게임 종료 후 우승자를 알려주며, 우승자는 한 명 이상일 수 있다.

## 프로젝트 구조

- `domain.Car`
    - 자동차의 이름, 위치, 이동 담당

- `domain.CarRace`
    - 자동차 경주 진행, 우승자 판단

- `generator.NumberGenerator`
    - 숫자 생성 인터페이스

- `generator.RandomNumGenerator`
    - 랜덤 숫자 생성

- `Application`
    - 메인 메서드 실행

- `controller.GameController`
    - 게임의 전체적인 흐름 관리
