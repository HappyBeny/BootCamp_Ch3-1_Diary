package com.spring.basic.Diary.repository;

import com.spring.basic.Diary.dto.ScheduleDto;
import com.spring.basic.Diary.entity.ScheduleEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface TodosRepository {

    ScheduleDto save(ScheduleDto schedule);
    Optional<ScheduleEntity> findById(Long id);
    List<ScheduleEntity> findByWriter(String writer);
    List<ScheduleEntity> findByCreatedDate(LocalDate date);
    List<ScheduleEntity> findByUpdatedDate(LocalDate date);
    List<ScheduleEntity> findAll();
}
