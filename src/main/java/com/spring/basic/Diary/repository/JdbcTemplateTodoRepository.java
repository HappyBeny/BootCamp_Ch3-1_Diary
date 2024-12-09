package com.spring.basic.Diary.repository;

import com.spring.basic.Diary.dto.CreateScheduleDto;
import com.spring.basic.Diary.entity.ScheduleEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class JdbcTemplateTodoRepository implements TodosRepository{

    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateTodoRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public CreateScheduleDto save(CreateScheduleDto schedule) {
        String sql = "INSERT INTO schedules (todo, writer, password) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, schedule.getTodo(), schedule.getWriter(), schedule.getPassword());
        return schedule;
    }

    @Override
    public Optional<ScheduleEntity> findById(Long id) {
        List<ScheduleEntity> result = jdbcTemplate.query("select * from schedules where id = ?", scheduleRowMapper(), id);
        return result.stream().findAny();
    }

    @Override
    public List<ScheduleEntity> findByWriter(String writer) {
        List<ScheduleEntity> result = jdbcTemplate.query("select * from schedules where writer = ?", scheduleRowMapper(), writer);
        return result;
    }

    @Override
    public List<ScheduleEntity> findByCreatedDate(LocalDate date) {
        return jdbcTemplate.query("select * from schedules where created_time >= ? and created_time < ?",
                scheduleRowMapper(),
                Timestamp.valueOf(date.atStartOfDay()),
                Timestamp.valueOf(date.plusDays(1).atStartOfDay()));
    }

    @Override
    public List<ScheduleEntity> findByUpdatedDate(LocalDate date) {
        return jdbcTemplate.query("select * from schedules where updated_time >= ? and updated_time < ?",
                scheduleRowMapper(),
                Timestamp.valueOf(date.atStartOfDay()),
                Timestamp.valueOf(date.plusDays(1).atStartOfDay()));
    }

    @Override
    public List<ScheduleEntity> findAll() {
        return jdbcTemplate.query("select * from schedules", scheduleRowMapper());
    }

    private RowMapper<ScheduleEntity> scheduleRowMapper() {
        return (rs, rowNum) -> {
            ScheduleEntity schedule = new ScheduleEntity();
            schedule.setId(rs.getLong("id"));
            schedule.setTodo(rs.getString("todo"));
            schedule.setWriter(rs.getString("writer"));
            schedule.setCreatedTime(rs.getTimestamp("created_time").toLocalDateTime());
            schedule.setUpdatedTime(rs.getTimestamp("updated_time").toLocalDateTime());
            return schedule;
        };
    }
}
