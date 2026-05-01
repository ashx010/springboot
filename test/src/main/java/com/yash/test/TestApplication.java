package com.yash.test;

import com.yash.test.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(TestApplication.class, args);

		Student st = context.getBean(Student.class);

		st.setName("Lol");
		st.setRoll(12);

	}

}
