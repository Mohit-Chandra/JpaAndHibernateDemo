package com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Student")
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;


    @OneToOne(fetch = FetchType.LAZY)
    private Passport passport;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "STUDENT_COURSE"
            , joinColumns = @JoinColumn(name = "Student_ID"),
            inverseJoinColumns = @JoinColumn(name = "Course_ID"))
    private List<Course> arrCourse = new ArrayList<Course>();

    public List<Course> getArrCourse() {
        return arrCourse;
    }

    public void addCourse(Course course) {
        this.arrCourse.add(course);
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Student(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Default constructor is mandatory,as it is used by JPA to create a Bean
    protected Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
