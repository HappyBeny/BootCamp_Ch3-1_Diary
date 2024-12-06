package com.spring.basic.Diary.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Schedule {

    private Long id;
    private String todo;
    private String writer;
    private final String password;
    private final LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    public Schedule(String todo, String writer, String password) {
        this.todo = todo;
        this.writer = writer;
        this.password = password;
        this.createdTime = LocalDateTime.now();
        this.updatedTime = LocalDateTime.now();
    }
}
