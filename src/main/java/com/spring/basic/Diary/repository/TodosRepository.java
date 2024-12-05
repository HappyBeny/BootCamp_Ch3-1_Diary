package com.spring.basic.Diary.repository;

import com.spring.basic.Diary.domain.Schedule;

import java.util.List;
import java.util.Optional;


public interface TodosRepository {

    Schedule save(Schedule schedule);
    Optional<Schedule> findByDate(String date);
    Optional<Schedule> findByWriter(String writer);
    List<Schedule> showAllSchedules();
}
