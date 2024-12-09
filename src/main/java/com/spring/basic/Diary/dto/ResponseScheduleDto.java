package com.spring.basic.Diary.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ResponseScheduleDto {
    private Long id;
    private String todo;
    private String writer;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
