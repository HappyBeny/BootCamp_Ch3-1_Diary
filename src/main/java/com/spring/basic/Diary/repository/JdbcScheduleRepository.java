package com.spring.basic.Diary.repository;

import com.spring.basic.Diary.dto.Schedule;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class JdbcScheduleRepository implements TodosRepository{
    @Override
    public Schedule save(Schedule schedule) {
        return null;
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Schedule> findByWriter(String writer) {
        return List.of();
    }

    @Override
    public List<Schedule> findByCreatedDate(LocalDate date) {
        return List.of();
    }

    @Override
    public List<Schedule> findByUpdatedDate(LocalDate date) {
        return List.of();
    }

    @Override
    public List<Schedule> findAll() {
        return List.of();
    }
}
