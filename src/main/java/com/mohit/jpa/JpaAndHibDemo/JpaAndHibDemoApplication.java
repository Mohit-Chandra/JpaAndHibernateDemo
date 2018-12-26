package com.mohit.jpa.JpaAndHibDemo;

import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity.*;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.repository.CourseRepo;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.repository.EmployeeRepo;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.repository.StudentRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaAndHibDemoApplication implements CommandLineRunner {

	@Autowired
	CourseRepo courseRepo;

	@Autowired
	StudentRepo studentRepo;

	@Autowired
	EmployeeRepo employeeRepo;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(JpaAndHibDemoApplication.class,args);

	}

	@Override
	public void run(String... args) throws Exception {
		/*List<Review> reviewList = new ArrayList<>();

		Review review1= new Review("9","Best");
		Review review2= new Review("6","sO-SO");
		reviewList.add(review1);
		reviewList.add(review2);
		courseRepo.addReviewForCourse(10003L,reviewList);*/
		studentRepo.insertStudentAndCourse(new Student("Shashra"),new Course("Webservices"));
		/*employeeRepo.insert(new PartTimeEmployee("Shashra",new BigDecimal("50")));
		employeeRepo.insert(new FullTimeEmployee("Shashra",new BigDecimal("1000")));

		logger.info("All employees:{}",employeeRepo.getAllEmployees());*/

	}
}
