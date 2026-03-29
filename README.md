# 1단계 - 움직이는 자동차
## 요구사항
- 자동차 객체
  - 자동차는 자신만의 이름을 가진다
  - 자동차는 전진할 수 있다
    - 전진하기 위해 스스로 0부터 9사이의 정수를 무작위로 고른다
- 정상 작동하는지 테스트 한다.
## 구현
- `model.Car.java` : 자동차 객체
- `components.NumberGenerator.java` : 숫자 생성을 담당하는 인터페이스
- `components.RandomNumberGenerator.java` : 실제 자동차 객체에 사용하는 `components.NumberGenerator.java`의 구현체
- `components.CyclingNumberGenerator.java` : 테스트에서 사용할 `components.NumberGenerator.java`의 구현체

# 2단계 - 우승 자동차 구하기
## 요구사항
- n대의 자동차가 참여할 수 있다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 구할 수 있다. 우승자는 한 명 이상일 수 있다.
## 구현
- `model.Race.java` : 여러 자동차의 경주의 상태를 관리하는 구현체

# 3단계 - 우승 자동차 구하기
## 요구사항
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
## 구현
- `view.InputView.java` : 입력을 요구사항에 맞게 처리하는 클래스
- `view.OutputView.java` : 출력을 요구사항에 맞게 처리하는 클래스
- `controller.RaceController.java` : 2단계의 `model.Race.java`클래스를 대신해 전반적인 진행과정 제어
- `Main.java` : main 함수를 포함하는 클래스 

# 4단계 - 리펙토링
## 요구사항
- 테스트 작성
## 구현 
- MVC 패턴을 따르도록 코드를 재구성
- 보기 쉽게 페키지 분리
- 테스트 작성
