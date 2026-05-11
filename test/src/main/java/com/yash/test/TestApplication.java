package com.yash.test;

import com.yash.test.entity.Student;
import com.yash.test.service.StudentSer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TestApplication.class, args);

		Student st = context.getBean(Student.class);

		st.setName("xyz");
		st.setRoll(4);

		StudentSer ser = context.getBean(StudentSer.class);

		ser.addStudent(st);

		List<Student> stList = ser.getAllStudents();
		System.out.println(stList.toString());


	}

}
