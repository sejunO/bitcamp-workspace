# 비트캠프 디지털 컨버전스 기반 UI/UX Front 전문 개발자 양성 과정

## 교육 기간

2020-07-13 ~ 2020-12-21

## 교육 내용

### 1일차

- 개발 입문자 오리엔테이션
- 애플리케이션 개발 소개
- 애플리케이션 개발 도구 설치

### 2일차

- 서버 애플리케이션 개발 도구 설치
- 예제 프로젝트 다운로드 및 빌드
- 톰캣 서버에 배치 후 테스트 수행
- 실행 유형 소개(인터프리터/컴파일/자바)

### 3일차

- 비트, 바이트, 메모리, 데이터 저장 구동원리 소개
- 바이트코드 직접 작성 및 프로파일링 확인
- 작업 폴더를 GIT 저장소로 전환
- github.com에 개인 저장소(bitcamp-workspace) 생성
- github.com에 로컬 저장소를 업로드(push)
- 수업 관련 저장소를 로컬로 다운로드(clone)
- 자바 기본 프로그래밍 학습 프로젝트 생성
    - bitcamp-java-basic 폴더 생성
    - > gradle init 실행하여 프로젝트 폴더를 초기화시킨다.
- 실습
    - src/main/java/Hello2.java
    - src/main/java/com/eomcs/basic 폴더 생성
    - src/main/java/com/eomcs/basic/Hello2.java 생성
- 패키지 문법 사용 및 패키지 소속 클래스 실행하기
    - > java -classpath(cp) [class파일이 있는 폴더] [package명 포함 calss이름]
    
- git add 시 오류 발생
    - LF와 CRLF 문제
    - UNIX/LINUX 계열은 LF로 개행 문자
    - windows 는 CR/LF 형식으로 개행 문자
    -git config core.autocrlf ture 입력 후 add
    - 만약 Linux/MAC/UNIX라면 git config core.autocrlf input

### 4일차

- 소스 파일과 클래스 블록, 클래스 파일의 관계
    - com.eomcs.basic.ex01 패키지 예제
- 주석 종류와 사용법
    - com.eomcs.basic.ex02 패키지 예제
- 자바 언어로 값을 표현하는 문법(literal)
    -com.eoms.basic.ex03 패키지 예제

### 5일차(2020-07-17,금)

- 값을 메모리에 저장하는 방식
  - com.eomcs.basic.ex03 패키지 예제
  - 정수(양수와 음수)의 저장
  - 부동소수점을 저장하는 방법
  - 문자를 저장하는 방법
  - 논리 값을 저장하는 방법

#### 과제 - 프로젝트 관리 시스템 만들기

##### 저장소 및 프로젝트 폴더 준비하기

- 1) 저장소로 사용할 폴더 생성
  - c:\Users\bitcamp\bitcamp-java-project
- 2) 폴더를 git 저장소로 만든다.
- 3) github.com에 "bitcamp-java-project" 저장소를 생성한다.
- 4) 로컬 저장소를 원격 저장소에 연결하기
- 5) gradle 을 이용하여 저장소를 프로젝트 폴더로 만든다.
- 6) .gitignore 파일 준비하기
  - bitcamp-workspace에서 사용하는 파일을 그대로 복사한다.
- 7) 로컬 저장소에 백업 한 후 원격 저장소에 업로드

##### 구현 요구사항

- 한 명의 회원 정보를 콘솔로 출력한다.
- 한 개의 프로젝트 정보를 콘솔로 출력한다.
- 한 개의 작업 정보를 콜솔로 출력한다.

##### 실습


###### 1단계 - 한 명의 회원 정보를 출력한다

Mini-PMS를 이용하는 회원 정보를 출력한다. 일단 한 명의 정보만 출력한다.

```console
[회원]
번호: 101
이름: 홍길동
이메일: hong@test.com
암호: 1111
사진: hong.png
전화: 1111-2222
가입일: 2020-01-01
```

[작업 파일]

- com.eomcs.pms.App  클래스 변경
- src/test/java/com/eomcs/pms/AppTest.java 삭제
  - 당장 JUnit 관련 코딩은 하지 않기 때문에 제거한다.

###### 2단계 - 한 개의 프로젝트 정보를 출력한다

회원이 진행할 프로젝트 정보를 출력한다. 일단 한 개의 프로젝트 정보만 출력한다.

```console
[프로젝트]
번호: 1201
프로젝트명: 미니 프로젝트 관리 시스템 개발
내용: 소규모 팀을 위한 프로젝트 관리 시스템을 개발한다.
시작일: 2020-01-01
종료일: 2020-12-31
만든이: 홍길동
팀원: 홍길동,김구,유관순,안중근,윤봉길
```

[작업 파일]

- com.eomcs.pms.App2  클래스 추가
  
###### 3단계 - 한 개의 작업 정보를 출력한다

프로젝트에서 수행할 작업 정보를 출력한다. 일단 한 개의 작업 정보만 출력한다.

```console
[작업]
프로젝트: 미니 프로젝트 관리 시스템 개발
번호: 1
내용: 요구사항 수집
완료일: 2020-01-20
상태: 진행중
담당자: 홍길동
```

[작업 파일]

- com.eomcs.pms.App3  클래스 추가


[실습 결과]

- src/main/java/com/eomcs/pms/App.java 변경
- src/main/java/com/eomcs/pms/App2.java 추가
- src/main/java/com/eomcs/pms/App3.java 추가
- src/test/java/com/eomcs/pms/AppTest.java 삭제

### 6일차(2020-07-20, 월)

교육 환경을 Windows에서 Linux로 변경
 - 리눅스 설치하기
 - 개발 도구 설치하기
 - 프로젝트 폴더 준비

### 7일차(2020-07-21,화)

 macOS 개발 환경 구축하기

  - macOS 개발 도구 설치하기
  - bash 쉘을 zsh 쉘로 변경하기
  - oh-my-zsh 플러그인 추가하기
  - 5일차 과제 풀이
  - 연습
   - 자바 프로젝트(bitcamp-java-project) 만들기
   - 자바 프로젝트 실행하기
    - > gradle run
   - 자바 프로젝트 빌드하기
    - > gradle build
   - Eclipse IDE로 프로젝트 가져오기

### 8일차(2020-07-22,수)

  - Gradle로 자바 프로젝트를 eclipse 프로젝트로 설정
    - 'build.gradle' 빌드 스크립트 파일 plugin에 id 'eclipse' 추가
  - 이클립스 설정 파일 생성
    - > gradle eclipse
  - Eclipse IDE로 프로젝트 가져오기
    - bitcamp-java-project import
    - bitcamp-java-basic import

### 10일차(2020-07-24,금)

  - 예제 프로젝트 수행(bitcamp-java-project)
    - 02 버전 수행: 리터럴과 콘솔 출력 다루기
    - 03 버전 수행: 변수와 키보드 입력 다루기
    - 04 버전 수행: 배열과 흐름 제어문 활용하기
      - 배열과 흐름제어문의 활용처 확인하기

### 11일차(2020-07-27,월)

  - 변수를 다루는 방법 II
    - com.eomcs.basic.ex04 패키지 예제
    - Exam0510 ~ Exam0950 클래스
    - 포인터의 개념(hello.c), 배열과 래퍼런스, 상수
    - 클래스 변수와 인스턴스 변수, 로컬 변수
    - 변수와 블록, 형변환
  
### 12일차(2020-07-28,화)
  - 연산자 사용법
    - com.eomcs.basic.ex05 패키지 예제
    - 산술연산자, 연산자 우선순위, 연산의 결과 타입, 명시적 형변환과 암시적 형변환
    - 관계 연산자, 부동소수점의 비교에서 주의할 점
    - 비트 연산자
    - Exam0110 ~ Exam0355 클래스

### 13일차(2020-07-29,수)
  - 연산자 사용법
    - com.eomcs.basic.ex05 패키지 예제
    - 비트 이동 연산자, 증감 연산자, 할당 연산자
    - Exam0360 ~ Exam0710 클래스

### 14일차(2020-07-30,목)
  - 흐름 제어문 사용법
    - eom.eomcs.basic.ex06 패키지 예제
    - Exam0110 ~ Exam0421 클래스

### 15일차(2020-07-31,금)
  - 흐름 제어문 사용법
    - com.eomcs.basic.ex06 패키지 예제
    - Exam0430 ~ Exam0471  클래스
  - 예제 프로젝트 수행(bitcamp-java-project)
    - 04 버전 수행: 배열과 흐름 제어문 활용하기
      - 배열과 흐름제어문의 활용처 확인하기
      - App2, App3 다시 연습
    - 05 버전 수행: 클래스를 이용하여 새 데이터 타입 정의하기
      - App, App2, App3 변경

### 16일차(2020-08-03,월)
  - 예제 프로젝트 수행(bitcamp-java-project)
    - 05 버전 다시 수행: 프로그램의 시작점, main()
      - App 변경
      - App2, App3 삭제 -06 버전 수행: 메서드의 존재 이유
      - App 변경
  - 메서드 사용법
    - com.eomcs.basic.ex07 패키지 예제
    - Exam0110 ~ Exam0630 클래스
