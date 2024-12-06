package com.spring.basic.Diary;

import com.spring.basic.Diary.repository.MemoryTodoRepository;
import com.spring.basic.Diary.repository.TodosRepository;
import com.spring.basic.Diary.service.TodoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    private final TodosRepository todosRepository;

    public SpringConfig(TodosRepository todosRepository) {
        this.todosRepository = todosRepository;
    }

    @Bean
    public TodoService todoService() {
        return new TodoService(todosRepository);
    }

    @Bean
    public TodosRepository todosRepository() {
        return new MemoryTodoRepository();
    }

    TodosRepository todo = new MemoryTodoRepository();
}