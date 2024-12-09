package com.spring.basic.Diary.controller;


import com.spring.basic.Diary.dto.CreateScheduleDto;
import com.spring.basic.Diary.dto.ResponseScheduleDto;
import com.spring.basic.Diary.dto.ResponseUpdatedDto;
import com.spring.basic.Diary.dto.UpdateScheduleDto;
import com.spring.basic.Diary.entity.ScheduleEntity;
import com.spring.basic.Diary.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/todo")
@RestController
public class TodoController {

    // 속
    private final TodoService todoService;

    // 생
    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // 기
    @PostMapping("/schedules/new")
    public String create(@RequestBody CreateScheduleDto schedule) {
        System.out.println("schedule: " + schedule.getTodo());

        todoService.createSchedule(schedule);

        return "redirect:/schedules";
    }

    @GetMapping("/schedules")
    public List<ResponseScheduleDto> getSchedules(
            @RequestParam(value = "writer", required = false) String writer,
            @RequestParam(value = "updatedTime", required = false) LocalDate date) {

        List<ScheduleEntity> scheduleEntities = todoService.getSchedules(writer, date);

        return scheduleEntities.stream()
                .map(entity -> new ResponseScheduleDto(
                        entity.getId(),
                        entity.getTodo(),
                        entity.getWriter(),
                        entity.getCreatedTime(),
                        entity.getUpdatedTime()))
                .collect(Collectors.toList());
    }

    @GetMapping("/schedules/{id}")
    public Optional<ScheduleEntity> getSchedule(@PathVariable Long id) {
        return todoService.getScheduleWithId(id);
    }

    @PatchMapping("/schedules/update")
    public ResponseUpdatedDto update(@RequestBody UpdateScheduleDto schedule) {
        boolean updated =  todoService.updateSchedule(schedule.getId(), schedule.getTodo(), schedule.getWriter(), schedule.getPassword());

        if (updated) {
            return new ResponseUpdatedDto("Success", "수정 성공");
        } else {
            return new ResponseUpdatedDto("Fail", "올바른 비밀번호를 입력하세요");
        }
    }
}
