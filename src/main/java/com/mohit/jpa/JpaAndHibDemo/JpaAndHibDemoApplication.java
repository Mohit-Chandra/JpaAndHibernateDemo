package com.mohit.jpa.JpaAndHibDemo;

import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity.Course;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.repository.CourseRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaAndHibDemoApplication implements CommandLineRunner {

	@Autowired
	CourseRepo courseRepo;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {



		SpringApplication.run(JpaAndHibDemoApplication.class,args);

	}

	@Override
	public void run(String... args) throws Exception {
		/*Course c1 = courseRepo.findById(10001L);
		logger.info("Course with id is :{}",c1);
		Course newCourse = new Course("Miccroservices");
		 courseRepo.save(newCourse);
*/
		//courseRepo.deleteById(10002L);
		courseRepo.playWithEm();
	}
}
