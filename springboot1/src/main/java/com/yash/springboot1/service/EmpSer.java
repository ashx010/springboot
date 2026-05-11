package com.yash.springboot1.service;

import com.yash.springboot1.entity.Emp;
import com.yash.springboot1.repo.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpSer {

    private EmpRepo repo;

    public EmpRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(EmpRepo repo) {
        this.repo = repo;
    }

    public void addEmployee(Emp emp){
        repo.save(emp);
    }

    public List<Emp> getEmpList(){
        return repo.empList();
    }
}
