package com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.repository;

import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@Transactional
@Repository
public class CourseRepo {

    @Autowired
    EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Course findById(Long id){
       return entityManager.find(Course.class,id);
    }

    public void save(Course course){
        if(course.getId()!=null)
        {
           entityManager.merge(course);
        }else{
            entityManager.persist(course);
        }
    }

    public void deleteById(Long id){
            Course course = findById(id);
            entityManager.remove(course);
    }
    public void playWithEm(){
        logger.info("PlaywithEm start");
        Course course1 = new Course("Java");
        entityManager.persist(course1);
        course1.setName("Java EE");

        Course course2 = new Course("Angular Js");
        entityManager.persist(course2);
        course2.setName("Angular  js updated");

    }
}
