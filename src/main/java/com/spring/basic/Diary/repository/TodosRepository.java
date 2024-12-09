package com.spring.basic.Diary.repository;

import com.spring.basic.Diary.dto.RequestCreateDto;
import com.spring.basic.Diary.entity.ScheduleEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface TodosRepository {

    RequestCreateDto save(RequestCreateDto schedule);
    Optional<ScheduleEntity> findById(Long id);
    List<ScheduleEntity> findByWriter(String writer);
    List<ScheduleEntity> findByCreatedDate(LocalDate date);
    List<ScheduleEntity> findByUpdatedDate(LocalDate date);
    List<ScheduleEntity> findAll();
    void updateTodo(Long id, String todo);
    void updateWriter(Long id, String writer);
    void deleteSchedule(Long id);
    boolean verifyPassword(Long id, String password);
}
