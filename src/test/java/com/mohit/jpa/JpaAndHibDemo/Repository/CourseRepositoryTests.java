package com.mohit.jpa.JpaAndHibDemo.Repository;

import com.mohit.jpa.JpaAndHibDemo.JpaAndHibDemoApplication;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity.Course;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.repository.CourseRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class) // Is used to launch a Spring-Context
@SpringBootTest(classes=JpaAndHibDemoApplication.class) //It would launch an entire context
public class CourseRepositoryTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	CourseRepo courseRepo;
	@Test
	public void findByIdTest() {
		Course course = courseRepo.findById(10002L);
		assertEquals("spring",course.getName());
		logger.info("Test is Running");
	}

	@Test
	@DirtiesContext// it will restore the store as it was at start so that findbyIdTest can run
	public void deleteByIdTest() {
		courseRepo.deleteById(10002L);
		assertNull(courseRepo.findById(10002L));
	}

	@Test
	@DirtiesContext
	public void saveCourse(){
		Course course = courseRepo.findById(10002L);
		course.setName("Java");
		courseRepo.save(course);
		assertEquals("Java",course.getName());
	}

	@Test
	@DirtiesContext
	public void playWithEm(){
		courseRepo.playWithEm();
	}

}
