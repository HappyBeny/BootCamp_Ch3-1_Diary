package com.spring.basic.Diary.service;

import com.spring.basic.Diary.repository.TodosRepository;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    private final TodosRepository todosRepository;

    public TodoService(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }
}
