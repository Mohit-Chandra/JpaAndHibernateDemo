package com.mohit.jpa.JpaAndHibDemo.Repository;

import com.mohit.jpa.JpaAndHibDemo.JpaAndHibDemoApplication;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity.Course;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity.Review;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.repository.CourseRepo;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.repository.CourseSpringDataRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class) // Is used to launch a Spring-Context
@SpringBootTest(classes=JpaAndHibDemoApplication.class) //It would launch an entire context
public class CourseSpringDataRepositoryTests {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseSpringDataRepo courseSpringDataRepo;

	@Test

	public void findById(){

		Optional<Course> courseOptional = courseSpringDataRepo.findById(10001L);
		assertTrue(courseOptional.isPresent());
		//logger.info("{}",courseOptional.isPresent());

	}

	@Test

	public void playingAroundWithSpringDataRepo(){
		/*Course course = new Course("JPA");
		courseSpringDataRepo.save(course);

		course.setName("JPA in 40");
		courseSpringDataRepo.save(course);*/

		logger.info("{}",courseSpringDataRepo.count());
	}

	@Test
	public void sort(){
		Sort sort = new Sort(Sort.Direction.DESC,"name");
		logger.info("Courses -{}",courseSpringDataRepo.findAll(sort));
	}

	@Test
	public void paginationAndSort(){
		PageRequest pageRequest = PageRequest.of(0,3);
		Page<Course> firstPage = courseSpringDataRepo.findAll(pageRequest);
		logger.info("Courses -{}", firstPage.getContent());
	}

	@Test
	public void findUsingName(){

		logger.info("FindByName-{}",courseSpringDataRepo.countByName("hibernate"));
	}



}
