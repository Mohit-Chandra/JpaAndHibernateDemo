package com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Course")
@NamedQuery(name="get_all_courses",query="Select c from Course c")


public class Course {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;
    @CreationTimestamp
    private LocalDateTime createdDate;

    public Course(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }


    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<Review>();


    public List<Student> getArrStudent() {
        return arrStudent;
    }

    public void addStudent(Student student) {
        this.arrStudent.add(student);
    }

    @ManyToMany(mappedBy="arrCourse")
    private List<Student> arrStudent = new ArrayList<Student>();

    public List<Review> getReviews() {
        return reviews;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }
    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Default constructor is mandatory,as it is used by JPA to create a Bean
    protected Course() {
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
