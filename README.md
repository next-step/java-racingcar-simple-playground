# java-racingcar-simple-playground

자동차 경주 미션

## 개요
자동차 경주 미션은 간단한 콘솔 애플리케이션으로, 사용자로부터 경주할 자동차의 이름과 시도할 횟수를 입력 받습니다.\
그리고 이후 주어진 조건에 따라 자동차를 이동하여 최종 우승자를 구합니다.

## 프로젝트 구조
```
- domain/
 - Car.java : 자동차 객체 및 관련 메소드 정의
 - CarRegistry.java : 자동차 목록 관리
 - Game.java : 전반적인 게임 실행 담당
 - RoundResult.java : 게임 결과를 담는 객체
- generator/
 - NumberGenerator.java : 숫자 생성기 Interface 정의
 - RandomNumberGenerator.java : 랜덤 숫자 생성기
- view/
 - InputView.java : 사용자로부터 입력 받는 기능 수행
 - ResultView.java : 사용자에게 출력 하는 기능 수행
- Main.java  : Main Entrypoint
```

## 시작하기
### 1. 저장소 복제
```bash
$ git clone https://github.com/chemistryx/java-racingcar-simple-playground
$ cd java-racingcar-simple-playground/
```

### 2. 프로젝트 빌드
```bash
$ ./gradlew build
```

### 3. 프로젝트 실행
```bash
$ java -jar build/libs/java-racingcar-1.0-SNAPSHOT.jar
```
