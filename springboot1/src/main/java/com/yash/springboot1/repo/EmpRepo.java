package com.yash.springboot1.repo;

import com.yash.springboot1.entity.Emp;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmpRepo {

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    private JdbcTemplate jdbc;

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Emp emp) {

        String sql= "insert into emp (id, name) values (?, ?)";
        int rows = jdbc.update(sql, emp.getId(), emp.getName());
        System.out.println("Added " + rows );
    }

    public List<Emp> empList(){
        String sql = "select * from emp";

        RowMapper<Emp> rowMap = new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {
                Emp em = new Emp();
                em.setId(rs.getInt("id"));
                em.setName(rs.getString("name"));
                return em;
            }
        };

        return jdbc.query(sql, rowMap);
    }
}
