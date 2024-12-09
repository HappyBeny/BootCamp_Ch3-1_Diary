package com.spring.basic.Diary.service;

import com.spring.basic.Diary.dto.CreateScheduleDto;
import com.spring.basic.Diary.entity.ScheduleEntity;
import com.spring.basic.Diary.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TodoService {
    //속
    @Autowired
    private final TodosRepository todosRepository;


    //생
    public TodoService(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }


    //기
    /**
     * 일정 생성/등록
     * @param schedule 전달 받을 schedule 객체
     * @return 일정 생성 후 일정 내용 반환
     */
    public String createSchedule(CreateScheduleDto schedule) {
        todosRepository.save(schedule);
        return schedule.getTodo();
    }

    /**
     * 일정 조회 기능
     * @param writer 작성자
     * @param date 수정일
     * @return 입력된 값 갯수에 따라 각각의 리스트 반환.
     */
    public List<ScheduleEntity> getSchedules(String writer, LocalDate date) {
        if (writer == null && date == null) {
            return todosRepository.findAll();
        } else if (writer == null) {
            return todosRepository.findByUpdatedDate(date);
        } else if (date == null) {
            return todosRepository.findByWriter(writer);
        } else {
            return todosRepository.findByUpdatedDate(date).stream()
                    .filter(schedule -> schedule.getWriter().equals(writer))
                    .collect(Collectors.toList());
        }
    }

    /**
     * id로 조회하기(단건 일정 조회)
     * @param id 식별용 고유 id 입력
     * @return 입력된 id에 해당하는 객체 반환
     */
    public Optional<ScheduleEntity> getScheduleWithId(Long id) {
        return todosRepository.findById(id);
    }

    public void updateSchedule(Long id, String todo, String writer, String password) {
        if (!todosRepository.verifyPassword(id, password)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        if (writer == null && todo == null) {
            throw new IllegalStateException("적어도 한 가지 값을 입력해주세요");
        }

        if (todo != null) {
            todosRepository.updateTodo(id, todo);
        }

        if (writer != null) {
            todosRepository.updateWriter(id,writer);
        }
    }

}
