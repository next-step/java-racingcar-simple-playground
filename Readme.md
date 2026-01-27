java-racingcar refactor
================

## 1. 리팩토링 사항
### 1.1 기존 `WinnerSelector`를 `Cars`로 옮김.
- `WinnerSelector`는 상태없는 객체였고, 역할이 Cars의 우승자 선택이기때문에, Cars 내부 도메인 규칙으로 둬도 괜찮다고 생각했습니다.

### 1.2 `RoundResult`추가
- `Consumer`같은 함수형 인터페이스를 없애고, `Application`에서의 반복문 없이 출력을 어떻게 처리할까를 고민하였습니다.
- `RacingCarGame`에서 반복문 돌리기 위해서 `RoundResult`라는 중간 클래스를 만들었습니다.
- `RoundResult`는 `Cars`와 `Car`의 내부 상태는 변하지만, `RoundResult`는 해당 시점의 값을 복사하여 리스트 형태로 저장합니다.
- 따라서, `Cars`의 이름과 위치를 담은 각 라운드는 `List<RoundResult>`로 모아 반환합니다. 

### 1.3. service layer에 있는 코드들은 각 도메인들에게 적절한 책임으로 분리
- 저의 지식으로는 `RacingCarGame`에 있는 코드들을 각 도메인에게 책임을 분리하여 클래스를 없애기는 어려웠습니다.
- 멘토님께서 말씀하신 것처럼, `RacingCarGame`을 제거하는 방향이 가능하다면, 어떠한 방법으로 도메인에 위임하는게 좋을까요? 조언 부탁드립니다..

### 1.4 기타
- `tryCount >= 1`과 같은 규칙은 `inputview`에 둘까 `RacingCarGame`에 둘까 고민하다가, 도메인 규칙인 것 같아, `RacingCarGame`에 그대로 두었습니다.
