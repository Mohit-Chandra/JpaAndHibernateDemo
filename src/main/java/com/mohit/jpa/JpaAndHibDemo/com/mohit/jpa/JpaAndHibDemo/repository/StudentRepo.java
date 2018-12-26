package com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.repository;

import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity.Course;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity.Passport;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


@Transactional
@Repository
public class StudentRepo {

    @Autowired
    EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Student findById(Long id) {
        return entityManager.find(Student.class, id);
    }

    public void save(Student student) {
        if (student.getId() != null) {
            entityManager.merge(student);
        } else {
            entityManager.persist(student);
        }
    }

    public void deleteById(Long id) {
        Student student = findById(id);
        entityManager.remove(student);
    }

    public void saveStudentWithPassport() {

        Passport passport = new Passport("Z12345");
        entityManager.persist(passport);

        Student student = new Student("Mike");
        student.setPassport(passport);
        entityManager.persist(student);
    }



    public void insertStudentAndCourse(Student student, Course course) {
       /* Student student = new Student("Shashank");
        Course course = new Course("MicroServices");
        entityManager.persist(student);
        entityManager.persist(course);
        student.addCourse(course);
        course.addStudent(student);
        entityManager.persist(student);*/

        student.addCourse(course);
        course.addStudent(student);
        entityManager.persist(student);
        entityManager.persist(course);

    }
}
