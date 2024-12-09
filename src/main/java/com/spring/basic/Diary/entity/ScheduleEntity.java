package com.spring.basic.Diary.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ScheduleEntity {

    private Long id;
    private String todo;
    private String writer;
    private String password; // 순수jdbc용
    private LocalDateTime createdTime; // 순수 jdbc용
    private LocalDateTime updatedTime;

    public ScheduleEntity() {}

    public ScheduleEntity(Long id, String todo, String writer, String password, LocalDateTime createdTime, LocalDateTime updatedTime) {
        this.id = id;
        this.todo = todo;
        this.writer = writer;
        this.password = password;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }
}
