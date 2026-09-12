# 자동차 경주

## 설명
- 자동차 전진(4이상) 또는 정지(3이하)
- 자동차 리스트 저장으로 n대의 자동차 경주 가능
- 우승자 찾기 가능
- 랜덤 숫자 생성 가능

## 패키지 구조
```
racingcar
├── Car.java             # 이름과 위치를 가지며, 4 이상이면 전진
├── Cars.java            # n대의 Car를 리스트로 관리
├── RandomNumber.java    # 0~9 사이 랜덤 값 생성
├── CarMove.java         # 주어진 라운드 수만큼 자동차들을 이동
└── FindCarWinner.java   # 가장 높은 위치의 자동차를 우승으로 판별

test/racingcar
├── CarMovingTest.java     # 전진 또는 정지 테스트
├── CarsTest.java          # 자동차 목록 저장 테스트
└── FindCarWinnerTest.java # 단독/공동 우승자 테스트
```