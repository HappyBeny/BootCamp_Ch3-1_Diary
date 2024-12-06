package com.spring.basic.Diary.repository;

import com.spring.basic.Diary.domain.Schedule;

import java.time.LocalDate;
import java.util.List;


public interface TodosRepository {

    Schedule save(Schedule schedule);
    List<Schedule> findById(Long id);
    List<Schedule> findByWriter(String writer);
    List<Schedule> findByCreatedDate(LocalDate date);
    List<Schedule> findByUpdatedDate(LocalDate date);
    List<Schedule> findAll();
}
