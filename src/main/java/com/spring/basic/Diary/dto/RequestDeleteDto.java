package com.spring.basic.Diary.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RequestDeleteDto {
    private Long id;
    private String password;
}
