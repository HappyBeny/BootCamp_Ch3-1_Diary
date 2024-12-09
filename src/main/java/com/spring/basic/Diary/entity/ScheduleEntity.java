package com.spring.basic.Diary.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
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
}
