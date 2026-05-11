package com.yash.test.service;

import com.yash.test.entity.Student;
import com.yash.test.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSer {

    private StudentRepo repo;

    public StudentRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student stu) {
        repo.save(stu);
    }

    public List<Student> getAllStudents() {
        return repo.getAllStudents();
    }
}
