package com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.repository;

import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity.Employee;
import com.mohit.jpa.JpaAndHibDemo.com.mohit.jpa.JpaAndHibDemo.Entity.PartTimeEmployee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepo {
    @Autowired
    EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Employee findById(Long id) {
        return entityManager.find(Employee.class, id);
    }

    //insert an employee
    public void insert(Employee emp) {
        entityManager.persist(emp);
    }

    //retrieve all employees
    public List<PartTimeEmployee> getAllEmployees() {
        return entityManager
                .createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class)
                .getResultList();
    }
}
