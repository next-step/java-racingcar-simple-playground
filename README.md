# 2단계 - 우승 자동차 구하기

## **🚀 기능 요구사항**

- n대의 자동차가 참여할 수 있다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
  - 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 구할 수 있다. 우승자는 한 명 이상일 수 있다.

## **🎯 새로운 프로그래밍 요구사항**

- 우승자를 구하는 기능이 의도대로 동작하는지 테스트한다.

## **✏️  기존 프로그래밍 요구사항**

- 메인 메서드는 만들지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
  - 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java)을 원칙으로 한다.
- indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- else 예약어를 쓰지 않는다.
  - else 예약어를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
  - 힌트: if문에서 값을 반환하는 방식으로 구현하면 else 예약어를 사용하지 않아도 된다.
- 함수(또는 메소드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메소드)가 한 가지 일만 잘 하도록 구현한다.

<br>

## 🕹️ Controller

| Model | Method |
| --- | --- |
| Car | move |
| Cars | getWinner |

<br>

## 🚗  Model

| Model | Car | Cars         |
| --- | --- |--------------|
| Field | String name | List \<Car>  |
|  | int score |              |
| Method | move | save |
|  |  |calcualteWinner    |
|  |  | getWinner         |

<br>

## **📚 Utils**

| Util | Method |
| --- | --- |
| RandomNumberGenerator | generate |

<br>

## **🧪 Test**

| Method | Test |
| --- | --- |
| RandomNumberGenerator | 0에서 9사이의 정수를 반환하는가? |
| getWinner | 정확한 우승자를 반환하는가? |