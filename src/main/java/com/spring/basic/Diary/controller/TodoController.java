package com.spring.basic.Diary.controller;


import com.spring.basic.Diary.dto.Schedule;
import com.spring.basic.Diary.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
    public String create(@RequestBody Schedule schedule) {
        System.out.println("schedule: " + schedule.getTodo());

        todoService.createSchedule(schedule);

        return "redirect:/schedules";
    }

    @GetMapping("/schedules")
    public List<Schedule> getSchedules(
            @PathVariable("writer") String writer,
            @PathVariable("updatedTime") LocalDate date) {
        return todoService.getSchedules(writer, date);
    }
}
