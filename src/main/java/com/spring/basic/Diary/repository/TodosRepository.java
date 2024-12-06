package com.spring.basic.Diary.repository;

import com.spring.basic.Diary.domain.Schedule;

import java.time.LocalDateTime;
import java.util.List;


public interface TodosRepository {

    Schedule save(Schedule schedule);
    List<Schedule> findById(Long id);
    List<Schedule> findByWriter(String writer);
    List<Schedule> findByCreatedDate(LocalDateTime dateTime);
    List<Schedule> findByUpdatedDate(LocalDateTime dateTime);
    List<Schedule> findAll();
}
