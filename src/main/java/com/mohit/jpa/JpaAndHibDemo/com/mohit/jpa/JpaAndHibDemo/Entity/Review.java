package com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity;


import javax.persistence.*;

@Entity
@Table(name = "Review")
public class Review {

    @Id
    @GeneratedValue
    private Long id;

    private String rating;
    private String description;


    @ManyToOne
    private Course course;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Review(String rating, String name) {
        this.rating = rating;
        this.description = name;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //Default constructor is mandatory,as it is used by JPA to create a Bean
    protected Review() {

    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                "rating=" + rating +
                ", description='" + description + '\'' +
                '}';
    }
}
