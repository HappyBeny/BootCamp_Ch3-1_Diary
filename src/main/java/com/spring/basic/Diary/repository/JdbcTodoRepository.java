package com.spring.basic.Diary.repository;

import com.spring.basic.Diary.dto.Schedule;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class JdbcTodoRepository implements TodosRepository{

    private final DataSource dataSource;

    public JdbcTodoRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Schedule save(Schedule schedule) {
        String sql = "insert into schedule (todo, writer, password) values (?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, schedule.getTodo());
            pstmt.setString(2, schedule.getWriter());
            pstmt.setString(3, schedule.getPassword());

            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();

            if (rs.next()) {
                schedule.setId(rs.getLong(1));
            } else {
                throw new SQLException("id 조회 실패");
            }
            return schedule;
        } catch (Exception e){
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        String sql = "select * from schedule where id = ?";

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setLong(1, id);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(rs.getLong("id"));
                schedule.setTodo(rs.getString("todo"));
                schedule.setWriter(rs.getString("writer"));
                schedule.setCreatedTime(rs.getTimestamp("created_time").toLocalDateTime());
                schedule.setUpdatedTime(rs.getTimestamp("updated_time").toLocalDateTime());
                return Optional.of(schedule);
            } else {
                return Optional.empty();
            }
        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public List<Schedule> findByWriter(String writer) {
        String sql = "select * from schedule where writer = ?";
        List<Schedule> schedules = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, writer);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                    Schedule schedule = new Schedule();
                    schedule.setId(rs.getLong("id"));
                    schedule.setTodo(rs.getString("todo"));
                    schedule.setWriter(rs.getString("writer"));
                    schedule.setCreatedTime(rs.getTimestamp("created_time").toLocalDateTime());
                    schedule.setUpdatedTime(rs.getTimestamp("updated_time").toLocalDateTime());
                    schedules.add(schedule);
            }

            return schedules;

        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public List<Schedule> findByCreatedDate(LocalDate date) {
        String sql = "select * from schedule where created_time >= ? and created_time < ?";
        List<Schedule> schedules = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setTimestamp(1, Timestamp.valueOf(date.atStartOfDay()));
            pstmt.setTimestamp(2, Timestamp.valueOf(date.plusDays(1).atStartOfDay()));

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(rs.getLong("id"));
                schedule.setTodo(rs.getString("todo"));
                schedule.setWriter(rs.getString("writer"));
                schedule.setCreatedTime(rs.getTimestamp("created_time").toLocalDateTime());
                schedule.setUpdatedTime(rs.getTimestamp("updated_time").toLocalDateTime());
                schedules.add(schedule);
            }

            return schedules;

        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public List<Schedule> findByUpdatedDate(LocalDate date) {
        String sql = "select * from schedule where updated_time >= ? and updated_time < ?";
        List<Schedule> schedules = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setTimestamp(1, Timestamp.valueOf(date.atStartOfDay()));
            pstmt.setTimestamp(2, Timestamp.valueOf(date.plusDays(1).atStartOfDay()));

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(rs.getLong("id"));
                schedule.setTodo(rs.getString("todo"));
                schedule.setWriter(rs.getString("writer"));
                schedule.setCreatedTime(rs.getTimestamp("created_time").toLocalDateTime());
                schedule.setUpdatedTime(rs.getTimestamp("updated_time").toLocalDateTime());
                schedules.add(schedule);
            }

            return schedules;

        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    @Override
    public List<Schedule> findAll() {
        String sql = "select * from schedule";
        List<Schedule> schedules = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            conn = getConnection();
            pstmt = conn.prepareStatement(sql);

            rs = pstmt.executeQuery();

            while (rs.next()) {
                Schedule schedule = new Schedule();
                schedule.setId(rs.getLong("id"));
                schedule.setTodo(rs.getString("todo"));
                schedule.setWriter(rs.getString("writer"));
                schedule.setCreatedTime(rs.getTimestamp("created_time").toLocalDateTime());
                schedule.setUpdatedTime(rs.getTimestamp("updated_time").toLocalDateTime());
                schedules.add(schedule);
            }

            return schedules;

        } catch (Exception e) {
            throw new IllegalStateException(e);
        } finally {
            close(conn, pstmt, rs);
        }
    }

    private Connection getConnection() {
        return DataSourceUtils.getConnection(dataSource);
    }

    private static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
        try{
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (pstmt != null) {
                pstmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
