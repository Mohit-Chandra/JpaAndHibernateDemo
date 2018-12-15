package com.mohit.jpa.JpaAndHibDemo.Repository;

import com.mohit.jpa.JpaAndHibDemo.JpaAndHibDemoApplication;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
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


}
