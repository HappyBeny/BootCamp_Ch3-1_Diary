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

**<details><summary>Entity</summary>**

- **ScheduleEntity**: 일정의 데이터를 표현하는 엔티티 클래스  
  - **`id`**: 일정 ID (Long)  
  - **`todo`**: 할 일 (String)  
  - **`writer`**: 작성자 (String)  
  - **`password`**: 비밀번호 (String)  
  - **`createdTime`**: 생성 시간 (LocalDateTime)  
  - **`updatedTime`**: 수정 시간 (LocalDateTime)  

</details>

**<details><summary>DTO</summary>**

- **RequestCreateDto** : 일정 생성 요청 시 사용.
  - `todo`: 할 일 (String)  
  - `writer`: 작성자 (String)  
  - `password`: 비밀번호 (String)  

- **UpdateScheduleDto** : 일정 수정 요청 시 사용.
  - `id`: 일정 ID (Long)  
  - `todo`: 할 일 (String)  
  - `writer`: 작성자 (String)  
  - `password`: 비밀번호 (String)  

- **RequestDeleteDto** : 일정 삭제 요청 시 사용.
  - `id`: 일정 ID (Long)  
  - `password`: 비밀번호 (String)  

- **ResponseScheduleDto** : 일정 조회 응답용.
  - `id`: 일정 ID (Long)  
  - `todo`: 할 일 (String)  
  - `writer`: 작성자 (String)  
  - `createdTime`: 생성 시간 (LocalDateTime)  
  - `updatedTime`: 수정 시간 (LocalDateTime)  

- **ResponseUpdatedDto** : 작업 성공/실패 응답용.
  - `status`: 상태 (String)  
  - `message`: 메시지 (String)  

</details>

**<details><summary>Repository</summary>**

- **TodosRepository**: 일정 데이터 접근을 위한 인터페이스  
  - **기능**: 일정 생성, 조회, 수정, 삭제 관련 메서드 정의  

- **JdbcTemplateTodoRepository**: `JdbcTemplate`을 사용하여 일정 데이터를 관리하는 구현체  
  - **`save(RequestCreateDto schedule)`**  
    - 설명: 새로운 일정을 저장합니다.  
    - 반환값: 생성된 일정의 ID (Long)  

  - **`findById(Long id)`**  
    - 설명: ID로 일정 조회  
    - 반환값: 조회된 일정 (Optional<ScheduleEntity>)  

  - **`findByWriter(String writer)`**  
    - 설명: 작성자로 일정 조회  
    - 반환값: 일정 목록 (List<ScheduleEntity>)  

  - **`findByCreatedDate(LocalDate date)`**  
    - 설명: 생성 날짜로 일정 조회  
    - 반환값: 일정 목록 (List<ScheduleEntity>)  

  - **`findByUpdatedDate(LocalDate date)`**  
    - 설명: 수정 날짜로 일정 조회  
    - 반환값: 일정 목록 (List<ScheduleEntity>)  

  - **`findAll()`**  
    - 설명: 모든 일정 조회  
    - 반환값: 일정 목록 (List<ScheduleEntity>)  

  - **`updateTodo(Long id, String todo)`**  
    - 설명: 할 일 내용 수정  

  - **`updateWriter(Long id, String writer)`**  
    - 설명: 작성자 수정  

  - **`deleteSchedule(Long id)`**  
    - 설명: 일정 삭제  

  - **`verifyPassword(Long id, String password)`**  
    - 설명: 비밀번호 검증  
    - 반환값: 검증 성공 여부 (boolean)  

- **JdbcTodoRepository**: 순수 JDBC를 사용한 연습용 구현체  
- **MemoryTodoRepository**: 메모리 기반의 연습용 구현체  

</details>

**<details><summary>Service</summary>**

- **TodoService** : 비즈니스 로직 처리.
  - **`createSchedule(RequestCreateDto schedule)`**  
    - 설명: 새로운 일정을 저장합니다.  
    - 반환값: 생성된 일정의 ID (Long)  

  - **`getSchedules(String writer, LocalDate date)`**  
    - 설명: 작성자나 수정일 조건에 맞는 일정을 조회합니다.  
    - 반환값: 조건에 맞는 일정 목록 (List<ScheduleEntity>)  

  - **`getScheduleWithId(Long id)`**  
    - 설명: 특정 ID의 일정을 조회합니다.  
    - 반환값: 조회된 일정 (Optional<ScheduleEntity>)  

  - **`updateSchedule(Long id, String todo, String writer, String password)`**  
    - 설명: 일정의 할 일과 작성자를 수정합니다.  
    - 반환값: 수정 성공 여부 (boolean)  

  - **`deleteSchedule(Long id, String password)`**  
    - 설명: 비밀번호 확인 후 일정을 삭제합니다.  
    - 반환값: 삭제 성공 여부 (boolean)  

</details>

**<details><summary> Controller</summary>**

- **TodoController**: RESTful API를 통해 일정을 생성, 조회, 수정, 삭제합니다.

</details>

**<details><summary>Configuration</summary>**

- **SpringConfig**: 애플리케이션의 빈과 설정을 정의하는 클래스  
  - **`todoService()`**: `TodoService` 빈을 생성합니다.  

  - **`todosRepository()`**: `TodosRepository` 구현체를 설정합니다.  
    - 예시 구현체:  
      - `JdbcTemplateTodoRepository`  
      - `JdbcTodoRepository`  
      - `MemoryTodoRepository`  

</details>

<br><br>

## 6️⃣기술 스택
- 프레임워크 : Spring Boot
- 언어 : Java
- 빌드 도구 : Gradle
- 데이터베이스 : MySQL (JDBC, JdbcTemplate 사용)
- 라이브러리 : Lombok
- 개발 도구 : IntelliJ IDEA
- 버전 관리 : Git
- 테스트 : JUnit
<br><br>



