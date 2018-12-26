package com.mohit.jpa.JpaAndHibDemo.Repository;

import com.mohit.jpa.JpaAndHibDemo.JpaAndHibDemoApplication;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity.Passport;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity.Student;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.repository.StudentRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@RunWith(SpringRunner.class) // Is used to launch a Spring-Context
@SpringBootTest(classes = JpaAndHibDemoApplication.class) //It would launch an entire context
public class StudentRepositoryTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    StudentRepo studRepo;

    @Autowired
    EntityManager entityManager;

    @Test
    @Transactional
    public void retrieveStudentPassportDetails() {

        Student student = entityManager.find(Student.class, 20001L);
        logger.info("Student -- {}", student);
        logger.info("passport---{}", student.getPassport());
    }

    @Test
    @Transactional
    public void retrievePassportStudentDetails() {

        Passport passport = entityManager.find(Passport.class, 40001L);
        logger.info("Passport -- {}", passport);
        logger.info("Student---{}", passport.getStudent());
    }

    @Test
    @Transactional
    @DirtiesContext
    public void retrieveStudentAndCourses() {
        Student student = entityManager.find(Student.class, 20001L);
        logger.info("Student--{}", student);
       // logger.info("Courses---{}", student.getArrCourse());
    }


}
