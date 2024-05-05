# 1단계 - 움직이는 자동차

## 기능 요구사항

- 자동차는 이름을 가지고 있다.
- 자동차는 움직일 수 있다.
  - 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.

## 나의 구현

- 처음에는 move 메서드 안에서 random 값을 생성하여 범위 및 값을 확인하여 움직일 수 있게 했다.
- 이렇게 하면 테스트 코드 작성 시 지정한 값을 주기가 어려워 짐 (Mock으로 줄 수 있을거 같긴한데, 학습 범위는 아니니 패스..)
- 그렇기에 값을 외부에서 받을 수 있도록 하고, 자동차는 움직임 범위만을 확인해서 움직이는게 좋다고 생각하여 지금 같이 작성!

# 1.5단계 - 기능 리팩토링

- 1단계에서는 Car 클래스의 move 메서드에 value를 넣어주고, 범위에 대한 유효성을 Car 에서 확인했음

```java
public void move(int value) {
        if (isMovable(value)) {
            position++;
        }
    }

private boolean isMovable(int value) {
    checkRange(value);
    return value >= MOVABLE_BOUND;
}

private void checkRange(int value) {
    if (value > 9 || value < 0) {
        throw new RuntimeException("Invalid range");
    }
}
```

- 생각해보니 자동차는 position이 4를 넘었느냐의 여부만 확인하면 될거 같은데, 0~9까지의 범위 체크는 자동차에서 해줄게 아니라는 생각이 듦
- 따라서 position에 대한 책임을 갖는 객체를 만들기로 결정했고, PositionDecider를 생성함
- 요구사항에선 랜덤값을 넣어줘야하지만, 테스트에서는 고정값을 주는 것이 좋다 판단하여 PositionDecier를 인터페이스로 만들고 아래의 구현체 생성
  - StaticPositionDecider: 수동으로 값을 넣어줄 수 있음
  - RandomPositionDecider: 기존 요구사항인 0~9의 랜덤한 값 제공

```java
public interface PositionDecider {

    private void checkRange(int value) {
        if (value > 9 || value < 0) {
            throw new RuntimeException("Invalid range");
        }
    }

    default int getPosition() {
        final int value = generate();
        checkRange(value);
        return value;
    }

    int generate();
}
```

- getPosition의 메서드를 템플릿 메서드로 만들고, generate는 각 구현체에서 구현하여 값을 제공해주면 된다.

# 2단계 구현

## 기능 요구사항

- n대의 자동차가 참여할 수 있다.
- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 0에서 9 사이에서 random 값을 구한 후 random 값이 4 이상일 경우 전진하고, 3 이하의 값이면 멈춘다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 구할 수 있다. 우승자는 한 명 이상일 수 있다.

## 나의 구현

- Racing이라는 클래스의 생성자에서 횟수와 참가 자동차를 받고 canOpen이라는 메서드를 통해 횟수가 음수이거나 참가자가 없으면 예외블 발생시킴
- 나머지는 요구사항에 맞도록 최대한 구현해봄

```java
public class Racing {

    private int times = 0;
    private List<Car> cars = new ArrayList<>();

    public Racing(int times, Car... car) {
        canOpen(car);
        this.times = times;
        this.cars = List.of(car);
    }

  private void canOpen(int times, Car[] car) {
    if (times <= 0) {
      throw new IllegalArgumentException("times must be greater than 0");
    }

    if (car.length == 0) {
      throw new IllegalArgumentException("Racing cars must have at least one car");
    }
  }
}
```
