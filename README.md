# BootCamp_Ch3-1_Diary
# 0️⃣목차
## 1️⃣ 프로젝트 설명
## 2️⃣ API 명세서
## 3️⃣ ERD
## 4️⃣ 구현한 기능
## 5️⃣ 클래스/메서드 설명
## 6️⃣기술 스택
<br><br><br>

## 1️⃣ 프로젝트 설명
- 간단한 수준에서 일정을 생성/조회/수정/삭제할 수 있는 웹 애플리케이션
- 일정은 각각 다음의 값을 가진다.
  - id : 고유 식별자로, 사용자가 입력하는 것이 아니라 DB에서 자동으로 부여한다.
  - todo : 일정 내용. VARCHAR타입의 값이다.
  - writer : 작성자. VARCHAR타입의 값이다.
  - password : 비밀번호. 수정/삭제를 위한 검증에 필요한 값이다.  VARCHAR타입의 값이다.
  - created_time : 생성일자. TIMESTAMP타입의 값으로, DB에 입력되는 시점에 자동으로 부여된다. 저장할 때는 Date와 Time를 전부 저장하고, 조회 시에는 Date만 조회한다.
  - updated_time : 수정일자. TIMESTAMP타입의 값으로, DB에 입력되는 시점에 자동으로 부여되고, 수정 시 자동으로 갱신된다. 저장할 때는 Date와 Time를 전부 저장하고, 조회 시에는 Date만 조회한다.
<br><br>

## 2️⃣ API 명세서
https://documenter.getpostman.com/view/40135026/2sAYBd8U3U
<br><br>

## 3️⃣ ERD(Entity-Relationship Diagram)
![image](https://github.com/user-attachments/assets/138bf6a8-5cf4-4bec-be34-be712c3b14b0)
<br><br>

## 4️⃣ 구현한 기능
### 일정 생성
- 경로: /todo/schedules/new (POST)
- 설명: 새로운 일정을 생성합니다.
<br>

### 일정 목록 조회
- 경로: /todo/schedules (GET)
- 설명: 작성자나 날짜 조건에 맞는 일정을 조회합니다.
<br>

### 특정 일정 조회
- 경로: /todo/schedules/{id} (GET)
- 설명: 특정 ID의 일정을 조회합니다.
<br>

### 일정 수정
- 경로: /todo/schedules/update (PATCH)
- 설명: 할 일과 작성자를 수정합니다.
<br>

### 일정 삭제
- 경로: /todo/schedules/delete (DELETE)
- 설명: 비밀번호 확인 후 일정을 삭제합니다.
<br><br>

## 5️⃣ 클래스/메서드 설명

<br><br>

## 6️⃣기술 스택

<br><br>



