package com.spring.basic.Diary;

import com.spring.basic.Diary.repository.JdbcTemplateTodoRepository;
import com.spring.basic.Diary.repository.JdbcTodoRepository;
import com.spring.basic.Diary.repository.MemoryTodoRepository;
import com.spring.basic.Diary.repository.TodosRepository;
import com.spring.basic.Diary.service.TodoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final TodosRepository todosRepository;
    private final DataSource dataSource;

    public SpringConfig(TodosRepository todosRepository, DataSource dataSource) {
        this.todosRepository = todosRepository;
        this.dataSource = dataSource;
    }

    @Bean
    public TodoService todoService() {
        return new TodoService(todosRepository);
    }

    @Bean
    public TodosRepository todosRepository() {
//        return new MemoryTodoRepository();
//        return new JdbcTodoRepository(dataSource);
        return new JdbcTemplateTodoRepository(dataSource);
    }
}