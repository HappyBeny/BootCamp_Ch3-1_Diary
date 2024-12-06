package com.spring.basic.Diary.controller;


import com.spring.basic.Diary.domain.Schedule;
import com.spring.basic.Diary.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public String create(ScheduleForm form) {
        Schedule schedule = new Schedule(form.getTodo(), form.getWriter(), form.getPassword());

        System.out.println("schedule: " + schedule.getTodo());

        todoService.createSchedule(schedule);

        return "redirect:/schedules";
    }

    @GetMapping("/schedules")
    public List<Schedule> list(String writer, LocalDate date) {
        return todoService.getSchedules(writer, date);
    }
}
