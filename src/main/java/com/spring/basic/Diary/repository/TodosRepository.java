package com.spring.basic.Diary.repository;

import com.spring.basic.Diary.dto.Schedule;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface TodosRepository {

    Schedule save(Schedule schedule);
    Optional<Schedule> findById(Long id);
    List<Schedule> findByWriter(String writer);
    List<Schedule> findByCreatedDate(LocalDate date);
    List<Schedule> findByUpdatedDate(LocalDate date);
    List<Schedule> findAll();
}
