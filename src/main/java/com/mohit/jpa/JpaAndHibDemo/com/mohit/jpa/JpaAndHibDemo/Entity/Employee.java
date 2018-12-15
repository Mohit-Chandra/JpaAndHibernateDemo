package com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/*@Entity
@Inheritance(strategy=InheritanceType.JOINED)*/
@MappedSuperclass
//@DiscriminatorColumn(name="EmployeeType")
public abstract class Employee {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


    public Employee(String name) {
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
    protected Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
