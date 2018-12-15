package com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.repository;

import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity.Course;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


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

        Course course2 = findById(10002L);
        course2.setName("JPA");

    }

    public void addReviewForCourse(Long courseId,List<Review> reviewList) {

        //Get the course 10003L
        //add Review for it
        //Save to db
        Course course = findById(courseId);
        logger.info("List of reviews -{}",course.getReviews());
        for(Review review:reviewList) {
            course.addReview(review);
            review.setCourse(course);
            entityManager.persist(review);
        }
      }
}
