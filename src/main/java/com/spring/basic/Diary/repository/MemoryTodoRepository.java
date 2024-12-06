package com.spring.basic.Diary.repository;

import com.spring.basic.Diary.domain.Schedule;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MemoryTodoRepository implements TodosRepository{
    // 속

    private Map<Long, Schedule> schedules;
    private long sequence = 0L;
    //기

    @Override
    public Schedule save(Schedule schedule) {
        schedule.setId(++sequence);
        schedules.put(schedule.getId(), schedule);
        return schedule;
    }
    @Override
    public List<Schedule> findByWriter(String writer) {
        return schedules.values().stream()
                .filter(schedule -> schedule.getWriter().equals(writer))
                .collect(Collectors.toList());
    }

    @Override
    public List<Schedule> findByCreatedDate(LocalDate date) {
        return List.of();
    }

    @Override
    public List<Schedule> findByUpdatedDate(LocalDate date) {
        return schedules.values().stream()
                .filter(schedule -> schedule.getUpdatedTime().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<Schedule> findAll() {
        return new ArrayList<>(schedules.values());
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        return schedules.values().stream()
                .filter(schedule -> schedule.getId().equals(id))
                .findAny();
    }

    public void clearAll(){
        schedules.clear();
    }
}
