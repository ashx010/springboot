package com.yash.springboot1;

import com.yash.springboot1.entity.Emp;
import com.yash.springboot1.service.EmpSer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;


@SpringBootApplication
public class Application {
    public static void main(String[] args){
        ApplicationContext ctx = SpringApplication.run(Application.class, args);

        Emp emp1 = ctx.getBean(Emp.class);

        emp1.setId(1);
        emp1.setName("employee");

        EmpSer ser = ctx.getBean(EmpSer.class);

        ser.addEmployee(emp1);

        List<Emp> empList =  ser.getEmpList();
        System.out.println(empList.toString());
    }
}
