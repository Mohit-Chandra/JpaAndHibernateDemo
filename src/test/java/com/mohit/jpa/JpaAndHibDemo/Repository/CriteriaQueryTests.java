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
import javax.persistence.criteria.*;
import java.util.List;

@RunWith(SpringRunner.class) // Is used to launch a Spring-Context
@SpringBootTest(classes = JpaAndHibDemoApplication.class) //It would launch an entire context
public class CriteriaQueryTests {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    EntityManager entityManager;

    @Test
    public void criteria_getAllCourses(){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        Root<Course> courseRoot = cq.from(Course.class);

        TypedQuery<Course> typedQuery = entityManager.createQuery(cq.select(courseRoot));
        List<Course> resultList = typedQuery.getResultList();

        logger.info("Courses are --{}",resultList);
    }

    @Test
    public void criteria_courselike(){
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        Root<Course> courseRoot = cq.from(Course.class);
        Predicate likeSpring =cb.like(courseRoot.get("name"),"spring%");

        cq.where(likeSpring);

        TypedQuery<Course> typedQuery = entityManager.createQuery(cq.select(courseRoot));
        List<Course> courseLike100 = typedQuery.getResultList();

        logger.info("Course like spring--{}",courseLike100);
    }

    @Test
    public void courses_without_student(){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        Root<Course> courseRoot = cq.from(Course.class);

        Predicate courseWithoutStudent = cb.isEmpty(courseRoot.get("arrStudent"));

        cq.where(courseWithoutStudent);

        TypedQuery<Course> typedQuery = entityManager.createQuery(cq.select(courseRoot));
        List<Course> courseWithoutStudList = typedQuery.getResultList();
        logger.info("CourseWithoutStudent is ---{}",courseWithoutStudList);
    }

    @Test
    public void join(){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        Root<Course> courseRoot = cq.from(Course.class);

        Join<Object,Object> join = courseRoot.join("arrStudent");

       TypedQuery<Course> typedQuery = entityManager.createQuery(cq.select(courseRoot));
       List<Course> resultList = typedQuery.getResultList();

       logger.info("Join --{}",resultList);


    }

    @Test
    public void join_left(){

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        Root<Course> courseRoot = cq.from(Course.class);

        Join<Object,Object> join = courseRoot.join("arrStudent",JoinType.LEFT);

        TypedQuery<Course> typedQuery = entityManager.createQuery(cq.select(courseRoot));
        List<Course> resultList = typedQuery.getResultList();

        logger.info("Join --{}",resultList);


    }


}
