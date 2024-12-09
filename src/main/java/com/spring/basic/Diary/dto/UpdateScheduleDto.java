package com.spring.basic.Diary.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UpdateScheduleDto {
    private final Long id;
    private String todo;
    private String writer;
    private final String password;
}
