package com.spring.basic.Diary.repository;

import com.spring.basic.Diary.dto.RequestCreateDto;
import com.spring.basic.Diary.entity.ScheduleEntity;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class MemoryTodoRepository implements TodosRepository{
    // 속
    private Map<Long, ScheduleEntity> schedules = new HashMap<>();

    private long sequence = 0L;

    //기
    @Override
    public Long save(RequestCreateDto scheduleDto) {
        ScheduleEntity scheduleEntity = new ScheduleEntity();
        scheduleEntity.setId(++sequence);
        scheduleEntity.setTodo(scheduleDto.getTodo());
        scheduleEntity.setWriter(scheduleDto.getWriter());
        scheduleEntity.setPassword(scheduleDto.getPassword());
        scheduleEntity.setCreatedTime(LocalDateTime.now());
        scheduleEntity.setUpdatedTime(LocalDateTime.now());
        schedules.put(scheduleEntity.getId(), scheduleEntity);
        return scheduleEntity.getId();
    }

    @Override
    public List<ScheduleEntity> findByWriter(String writer) {
        return schedules.values().stream()
                .filter(schedule -> schedule.getWriter().equals(writer))
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleEntity> findByCreatedDate(LocalDate date) {
        return schedules.values().stream()
                .filter(schedule -> schedule.getCreatedTime().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleEntity> findByUpdatedDate(LocalDate date) {
        return schedules.values().stream()
                .filter(schedule -> schedule.getUpdatedTime().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }

    @Override
    public List<ScheduleEntity> findAll() {
        return new ArrayList<>(schedules.values());
    }

    @Override
    public Optional<ScheduleEntity> findById(Long id) {
        return schedules.values().stream()
                .filter(schedule -> schedule.getId().equals(id))
                .findAny();
    }

    @Override // 대충코드
    public void updateTodo(Long id, String todo) {

    }

    @Override // 대충코드
    public void updateWriter(Long id, String writer) {

    }

    @Override // 대충코드
    public void deleteSchedule(Long id) {

    }

    @Override // 대충코드
    public boolean verifyPassword(Long id, String password) {
        return false;
    }

    public void clearAll(){
        schedules.clear();
    }
}
