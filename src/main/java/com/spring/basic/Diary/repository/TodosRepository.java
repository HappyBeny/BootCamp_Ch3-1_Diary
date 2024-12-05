package com.spring.basic.Diary.repository;

import com.spring.basic.Diary.domain.Schedule;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


public interface TodosRepository {

    Schedule saveSchedule(Schedule schedule);
    Optional<Schedule> findById(Long id);
    Optional<Schedule> findByWriter(String writer);
    Optional<Schedule> findByDate(LocalDateTime dateTime);
    List<Schedule> showAllSchedules();
}
