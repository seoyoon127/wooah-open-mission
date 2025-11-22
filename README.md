# 프리코스 실행 어플

## 프로젝트 소개
우테코 8기 프리코스 과제를 모바일에서도 실행해볼 수 있도록 만든 안드로이드 애플리케이션입니다.  
프리코스 요구사항을 기반으로 로또, 자동차 경주, 문자열 덧셈 계산기 기능을 구현했습니다.

## 사용 기술
- 언어: Java
- 개발 환경: Android Studio
- 레이아웃: ConstraintLayout

## 주요 내용
### 공통 사항

<img width="222" height="430" alt="image" src="https://github.com/user-attachments/assets/e3b6bea7-9d30-4608-9048-b8e9a5130878" />


- 검증: 입력 조건에 맞지 않을 시 다음 페이지로 넘어가지 않음, 입력창 하단에 오류 메세지가 뜸
- 프리뷰: 이전 입력창에서 선택한 항목을 다음 페이지에서도 확인할 수 있음
- 기본 기능: 프리코스 요구사항을 준수함
### 로또
<img width="217" height="428" alt="로또 당첨" src="https://github.com/user-attachments/assets/6018b087-8e86-4483-96e0-87b2b14dfed3" />

- 로또별로 알파벳 순의 id와 당첨/낙첨 여부, 로또 번호를 확인 가능
- 당첨로또와 같은 번호는 배경 색상을 맞춤

### 자동차 경주
<img width="784" height="460" alt="image" src="https://github.com/user-attachments/assets/67cee619-9047-45f3-a637-a069ec8b453a" />


- 1칸 이동 시 자동차 좌측에 연기를 추가, 자동차 이동 애니메이션을 구현
- 우측 상단 roundInfo로 매 라운드별 진행상황 파악
- 결과 화면에 우승한 자동차의 이름과 해당 자동차 이미지를 표시
- 결과 화면에 모든 자동차의 순위와 이동 거리를 함께 제공

### 문자열 덧셈 계산기
<img width="217" height="425" alt="image" src="https://github.com/user-attachments/assets/d44fe35d-09d3-449d-aaa5-b8667d959535" />

- 입력 후 결과 확인 버튼을 눌러 덧셈 결과 확인

## 실행 영상
![전체 실행](https://github.com/user-attachments/assets/4a30495a-5c3e-47af-a105-3a5a93bd5f3d)
