package com.spring.basic.Diary.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Schedule {
    private String todo;
    private String writer;
    private final long password;
    private final String createdDate;
    private Date modifiedDate;

    public Schedule(String todo, String writer, long password, String createdDate) {
        this.todo = todo;
        this.writer = writer;
        this.password = password;
        this.createdDate = createdDate;
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

    public String getCreatedDate() {
        return createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
