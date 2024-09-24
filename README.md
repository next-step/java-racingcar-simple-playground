# 🚀 1단계 - 움직이는 자동차 🚀

## ❗️기능 요구사항❗️
* 자동차는 이름을 가지고 있다.
* 자동차는 움직일 수 있다.
  * 0에서 9사이에서 random값을 구한 후 4이상일 경우 전진하고, 3이하의 값이면 멈춘다.

## ✏️새로운 프로그래밍 요구사항 ✏️
* 자동차가 움직이는 기능이 의도대로 동작하는지 테스트한다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  * 기본적으로 Java Style Guide을 원칙으로 한다.
* indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
* 3항 연산자를 쓰지 않는다.
* else 예약어를 쓰지 않는다.
  * else 예약어를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
  * 힌트: if문에서 값을 반환하는 방식으로 구현하면 else 예약어를 사용하지 않아도 된다.
* 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  * 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.

## ☁️구현 사항 ☁️
✅ 자동차를 이름과 함께 현재 진행 값, 움직이는 메소드를 선언한다.<br/>
✅ 0~9사이의 random값을 구한다.<br/>
✅ 구한 random값이 4이상, 3이하인지 검사한다.<br/>
✅ 구한 random값이 4이상이면, 전진한 상태로 갱신한다.<br/>

# 🚀 2단계 - 우승 자동차 구하기🚀

## ❗️기능 요구사항❗️
* n대의 자동차가 참여할 수 있다.
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
  * 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 구할 수 있다. 우승자는 한 명 이상일 수 있다.

## ✏️새로운 프로그래밍 요구사항 ✏️
* 우승자를 구하는 기능이 의도대로 동작하는지 테스트한다.

## ☁️구현 사항 ☁️
✅ 1) n대의 자동차를 저장할 수 있게 만든다.<br/>
&nbsp;&nbsp;&nbsp;&nbsp; ✅ i) 전체 자동차를 저장할 수 있는 변수를 만든다.  
✅ 2) 주어진 횟수 동안 자동차의 전진 또는 정지 여부를 판단한다.<br/>
✅ 3) 가장 멀리 이동한 자동차를 구한다.<br/>
&nbsp;&nbsp;&nbsp;&nbsp; ✅ i) 최대 이동거리와 우승자 리스트를 설정한다.  
&nbsp;&nbsp;&nbsp;&nbsp; ✅ ii) 하나의 자동차씩 이동거리를 비교한다.  
&nbsp;&nbsp;&nbsp;&nbsp; ✅ iii) 이동거리가 같으면 우승자 리스트에 추가하고, 높으면 최대 이동거리와 우승자 리스트를 갱신한다.  

## ❓️고민 사항 ❓
* Map를 이용해서 이름과 함께 저장할 것인지, List를 이용할 것인지.  
=> 전체 자동차를 업데이트 해야하기 때문에 굳이 Map을 이용해 Key, Value를 안 만들어도 될 것 같다고 생각함.


* 우승자를 구할 때 가장 긴 거리를 구하고 그 거리만큼 이동한 자동차를 저장하는 방법과, 처음부터 자동차를 조회하면서 가장 멀리 간 거리가 나올 때마다 우승자 리스트도 갱신해야할지  
=> 두 번 조회하는 것 보다 한 번에 조회하는 것이 더 효율적이라 판단


* 향상된 for문을 사용하는 것이 좋을까, stream을 이용하는 것이 좋을까
=> 리스트 안의 객체를 통해 또 다른 객체를 생성하거나 만드는 것이 아니기 때문에 for - each가 더 좋을 것 같다고 생각함

# 🚀 3단계 - 게임 실행🚀

## ❗️기능 요구사항❗️
* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.

### 실행 결과
```yaml
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

## ✏️새로운 프로그래밍 요구사항 ✏️
* 메인 메서드를 추가하여 실행 가능한 애플리케이션으로 만든다.

## ☁️구현 사항 ☁️
✅ 1) 입력 안내문을 출력한다.<br/>
✅ 2) 자동차 이름을 입력받는다.<br/>
&nbsp;&nbsp;&nbsp;&nbsp; ✅ i) 쉼표로 구분된 자동차 이름을 구분한다.  
&nbsp;&nbsp;&nbsp;&nbsp; ✅ ii) 구분한 자동차 이름을 가지는 자동차를 생성하고 저장한다.  
&nbsp;&nbsp;&nbsp;&nbsp; ✅ iii) 이동할 거리를 나타낼 문자열 변수를 선언한다.  
✅ 3) 이동할 횟수를 입력받는다.<br/>
✅ 4) 실행 결과를 시도마다 출력한다.<br/>
&nbsp;&nbsp;&nbsp;&nbsp; ✅ i) 전진 혹은 정지 결과에 따라 문자열 변수를 갱신한다.  
&nbsp;&nbsp;&nbsp;&nbsp; ✅ ii) 이름과 이동거리를 나타내는 문자열을 출력한다.  
✅ 5) 최종 우승자를 출력한다.<br/>


## ❓️고민 사항 ❓
* stream()을 이용하면서 String 리스트를 Car 리스트로 변환하는 과정에서 생성자 매개변수로 정수 값이 하나 더 포함 되어 있는데 이를 처리
=> 찾아본 결과 Intstream을 사용하여 해결할 수도 있음


* CarsCreatorTest 중 usingRecursiveAssertion()으로는 통과하지 않았지만 usingRecursiveComparison()을 사용했을 때 통과함  
=> 객체 내용을 비교하는 것 까지는 맞는 것 같은데 CarCreatorTest에서는 result의 값이 객체 참조값의 리스트로 반환됨. 객체 내용은 같지만 참조값은 다르기에 실패했던 것으로 추측. 대신 Comparison은 리스트 안의 객체 내용까지 비교해주어서 통과한 것으로 추측됨. 공식문서 참조가 필요할 것 같음.

# 🚀 4단계 - 리팩토링 🚀

## ✏️새로운 프로그래밍 요구사항 ✏️
* 모든 로직에 단위 테스트를 구현한다. 단, UI(System.out, System.in) 로직은 제외한다.
  * 랜덤한 요소가 존재하는 코드는 어떻게 테스트할 수 있는지 경험한다.

## ☁️구현 사항 ☁️
✅ 1) 변하지 않는 상수 값 표시.<br/>
❌ 2) 예외 처리<br/>
&nbsp;&nbsp;&nbsp;&nbsp; ✅ i) 자동차 이름이 5자 초과일 경우 예외 처리.  
&nbsp;&nbsp;&nbsp;&nbsp; ✅ ii) 이동거리가 숫자가 아닐 경우 예외 처리.  

