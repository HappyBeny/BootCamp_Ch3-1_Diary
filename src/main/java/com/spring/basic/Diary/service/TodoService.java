package com.spring.basic.Diary.service;

import com.spring.basic.Diary.domain.Schedule;
import com.spring.basic.Diary.repository.MemoryTodoRepository;
import com.spring.basic.Diary.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    //속
    private final TodosRepository todosRepository;


    //생
    @Autowired
    public TodoService(MemoryTodoRepository todosRepository) {
        this.todosRepository = todosRepository;
    }


    //기
    public void addSchedule (Schedule schedule) {

    }

}
