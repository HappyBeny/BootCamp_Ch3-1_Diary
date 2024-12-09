package com.spring.basic.Diary.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateScheduleDto {

    private String todo;
    private String writer;
    private String password;

    public CreateScheduleDto() {}
}
