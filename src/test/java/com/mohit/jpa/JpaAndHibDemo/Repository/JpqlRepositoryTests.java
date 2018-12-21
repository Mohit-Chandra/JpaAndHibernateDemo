package com.mohit.jpa.JpaAndHibDemo.Repository;

import com.mohit.jpa.JpaAndHibDemo.JpaAndHibDemoApplication;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity.Course;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@RunWith(SpringRunner.class) // Is used to launch a Spring-Context
@SpringBootTest(classes = JpaAndHibDemoApplication.class) //It would launch an entire context
public class JpqlRepositoryTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager entityManager;

    @Test
    public void findByIdTest() {
        logger.info("Select c from Course c --{}",
                entityManager.createQuery("Select c from Course c").getResultList());
    }

    @Test
    public void findByIdTyped() {
        //TypedQuery<Course> query = entityManager.createQuery("Select c from Course c",Course.class);
        TypedQuery<Course> query = entityManager.createNamedQuery("get_all_courses", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c from Course c --{}", resultList);
    }

    @Test
    public void findByIdWithWhere() {
        TypedQuery<Course> query = entityManager.createQuery("Select c from Course c where id=1", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c from Course c --{}", resultList);
    }

    @Test
    public void jpql_course_without_student() {
        TypedQuery<Course> query = entityManager.createQuery("Select c from Course c where c.arrStudent is empty", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Resultlist --{}", resultList);
    }

    @Test
    public void jpql_course_withatleat2_student() {
        TypedQuery<Course> query = entityManager.createQuery("Select c from Course c where size(c.arrStudent)>=2 ", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Resultlist --{}", resultList);
    }

    @Test
    public void jpql_course_orderbysizeofstudents() {
        TypedQuery<Course> query = entityManager.createQuery("Select c from Course c order by size(c.arrStudent)", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Resultlist --{}", resultList);
    }

    @Test

    public void jpql_student_passport(){
        TypedQuery<Student> query = entityManager
                .createQuery("Select s from Student s where s.passport.number like 'E%'",Student.class);

        List<Student> listStudent = query.getResultList();

        logger.info("ListStudent --{}",listStudent);
    }

    @Test
    public void join_jpql(){

        Query query = entityManager.createQuery("Select c,s from Course c JOIN c.arrStudent s");
        List<Object[]> resultList = query.getResultList(); //gives course and student as array[0] and array[1]
        logger.info("Results size is {}",resultList.size());
        for(Object[] result:resultList)
        {
            logger.info("Course is{},Student is {}",result[0],result[1]);
        }

    }


}
