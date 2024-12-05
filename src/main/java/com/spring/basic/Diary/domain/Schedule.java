package com.spring.basic.Diary.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Schedule {

    private Long id;
    private String todo;
    private String writer;
    private final long password;
    private LocalDateTime dateTime;

    public Schedule(String todo, String writer, long password) {
        this.todo = todo;
        this.writer = writer;
        this.password = password;
        this.dateTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTodo() {
        return todo;
    }

    public void setTodo(String todo) {
        this.todo = todo;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public long getPassword() {
        return password;
    }

    public String getDate() {
        return dateTime.toString();
    }
}
