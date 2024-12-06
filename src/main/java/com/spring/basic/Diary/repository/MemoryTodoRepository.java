package com.spring.basic.Diary.repository;

import com.spring.basic.Diary.domain.Schedule;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
    public List<Schedule> findById(Long id) {
        return schedules.values().stream()
                .filter(schedule -> schedule.getId().equals(id))
                .collect(Collectors.toList());
    }

    @Override
    public List<Schedule> findByWriter(String writer) {
        return schedules.values().stream()
                .filter(schedule -> schedule.getWriter().equals(writer))
                .collect(Collectors.toList());
    }

    @Override
    public List<Schedule> findByDate(LocalDateTime dateTime) {
        return schedules.values().stream()
                .filter(schedule -> schedule.getUpdatedTime().equals(dateTime))
                .collect(Collectors.toList());
    }

    @Override
    public List<Schedule> findAll() {
        return new ArrayList<>(schedules.values());
    }

    public void clearAll(){
        schedules.clear();
    }
}
