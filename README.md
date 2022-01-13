## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---
## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---
1. 피드백 강의 전까지 미션 진행 
> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---
2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---
3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```

## 구현기능
1. 문자열을 입력받는다.
    - "숫자 연산자 숫자 연산자 숫자" 형식이어야 한다.
2. 입력받은 문자열을 숫자/연산자로 파싱한다.
    - 연산자는 +, -, *, /로 구성된다.
3. 숫자와 연산자를 조합하여 결과를 계산한다.
   - 연산자가 "+" 라면? -> a+b
   - 연산자가 "-" 라면? -> a-b
   - 연산자가 "x" 라면? -> axb
   - 연산자가 "/" 라면? -> a/b
4. 계산된 값을 출력한다.

## 객체
- Input : 문자열을 입력 받는다.
- Output : 결과를 출력한다.
- Operator : 주어진 숫자들로 단건 연산을 진행한다.
- Operators : 연산자들을 모아놓은 일급객체
- InputNumber : 입력받은 값의 타입을 보장한다.
- InputNumbers : 입력값들을 모아놓은 일급객체
- Calculator : 계산기 로직의 진행을 담당한다.

