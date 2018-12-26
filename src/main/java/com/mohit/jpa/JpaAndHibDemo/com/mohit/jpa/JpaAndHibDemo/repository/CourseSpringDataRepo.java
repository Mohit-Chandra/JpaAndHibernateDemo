package com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.repository;

import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


@RepositoryRestResource(path="courses")
public interface CourseSpringDataRepo extends JpaRepository<Course,Long> {

   List<Course> findByName(String name);

   List<Course> countByName(String name);




}
