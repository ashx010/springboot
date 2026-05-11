package com.yash.test.repository;

import com.yash.test.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepo {
    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    private JdbcTemplate jdbc;

    public void save(Student stu) {
        String sql = "insert into student (rollNo, name) values (?, ?)";
        int rows = jdbc.update(sql, stu.getRoll(), stu.getName());
        System.out.println("Added " + rows);
    }

    public List<Student> getAllStudents() {
        String sql = "select * from student";

        RowMapper<Student> rowMap = new RowMapper<Student>() {
            @Override
            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
                Student s = new Student();
                s.setRoll(rs.getInt("rollNo"));
                s.setName(rs.getString("name"));
                return s;
            }
        };

        return jdbc.query(sql, rowMap);
    }
}
