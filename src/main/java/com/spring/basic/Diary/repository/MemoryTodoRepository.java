package com.spring.basic.Diary.repository;

import com.spring.basic.Diary.domain.Schedule;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class MemoryTodoRepository implements TodosRepository{

    // 속
    private Map<Long, Schedule> schedules;
    private long sequence = 0L;

    //기
    @Override
    public Schedule saveSchedule(Schedule schedule) {
        schedule.setId(++sequence);
        schedules.put(schedule.getId(), schedule);
        return schedule;
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        return Optional.ofNullable(schedules.get(id));
    }

    @Override
    public Optional<Schedule> findByWriter(String writer) {
        return schedules.values().stream()
                .filter(schedule -> schedule.getWriter().equals(writer))
                .findAny();
    }

    @Override
    public Optional<Schedule> findByDate(LocalDateTime dateTime) {
        return schedules.values().stream()
                .filter(schedule -> schedule.getUpdatedTime().equals(dateTime))
                .findAny();
    }

    @Override
    public List<Schedule> showAllSchedules() {
        return new ArrayList<>(schedules.values());
    }

    public void clearSchedules(){
        schedules.clear();
    }
}
